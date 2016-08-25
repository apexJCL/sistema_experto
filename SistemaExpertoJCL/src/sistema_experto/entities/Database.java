package sistema_experto.entities;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_DIFFERENCEPeer;
import sistema_experto.common.RandomIO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by José Carlos López on 23/08/2016.
 */
public class Database {

    private RandomIO _db;
    private byte index = 0;
    public ArrayList<Rule> rules;

    /**
     * Creates (or opens) a new "Database" based on a RandomAccessFile
     *
     * @param filepath
     */
    public Database(String filepath) throws IOException {
        this._db = new RandomIO(filepath, RandomIO.FileMode.RW, true);
        if (this._db.newFile) {
            this.rules = new ArrayList<>(0);
            _initDB();
        }
        else _loadDB();
    }

    /**
     * Loads the DB Header from the file and sets the default parameters.
     * It loads each rule that appears after the header and until the EOF
     *
     */
    private void _loadDB() throws IOException {
        index = this._db.file.readByte();
        rules = new ArrayList<>(index);
        while (_db.file.getFilePointer() < _db.getSize())
            rules.add(_readRule());
        eof();
    }

    /**
     * Loads a rule from the database file
     *
     * @return Rule
     * @throws IOException
     */
    private Rule _readRule() throws IOException {
        Rule r = new Rule();
        r.setStartOffset(_db.file.getFilePointer());
        r.setRuleNumber(_db.file.readByte());
        for (byte i = 0; i < Rule.MAX_RECORDS; i++)
            r.getRecord()[i] = _db.file.readChar();
        r.setProduction(_db.file.readByte());
        r.description = _db.file.readLine();
        r.setEndOffset(_db.file.getFilePointer() - 1); // We leave 0A out, because each rule is delimited by a NL (0A)
        return r;
    }

    /**
     * This method initializes a database with a default header that includes
     * - Amount of rules in the database (Long)
     * - Last used key (for sequential addon) (Long)
     * - New Line
     * Total header size: 4 bytes
     */
    private void _initDB() throws IOException {
        this._db.file.writeByte(index);
    }

    /**
     * Adds a new rule to the database, at the EOF
     *
     * @param rule Rule to append
     */
    public void appendRule(Rule rule) throws IOException {
        eof();
        _db.file.writeByte(this.index); // Rule Number
        for (byte i = 0; i < Rule.MAX_RECORDS; i++){
            _db.file.writeChar(rule.getRecord()[i]);
        }
        _db.file.writeByte(rule.getProduction());
        _db.file.writeChars(rule.getDescription());
        this.index += 1;
        updateHeader();
    }

    /**
     * Updates the header of the database
     *
     * @throws IOException
     */
    public void updateHeader() throws IOException {
        _db.reset();
        this._initDB();
        this.eof();
    }

    /**
     * Moves pointer to the EOF, dummy wrapper
     * @throws IOException
     */
    private void eof() throws IOException {
        this._db.file.seek(this._db.getSize());
    }

    /**
     * Returns the number of the last inserted rule
     * @return
     */
    public long getIndex() { return index; }

    /**
     * Deletes a rule from the file, leaving a trailing 0A for rule delimiting
     *
     * @param r    Rule to erase
     * @return Always true, because it overwrites the rule section with 0's
     * @throws IOException
     */
    public boolean eraseRule(Rule r) throws IOException {
        _db.file.seek(r.getStartOffset());
        for (long i = r.getStartOffset(); i < r.getEndOffset(); i++)
            _db.file.writeByte(0);
        return true;
    }

    public void close() throws IOException {
        rules = null;
        _db.file.close();
    }
}
