package sistema_experto.entities;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by José Carlos López on 01/09/2016.
 */
public class RulesDatabase extends Database {

    public ArrayList<Rule> rules;
    private static final String FILE_EXTENSION = ".rdb";

    /**
     * Creates (or opens) a new "Database" based on a RandomAccessFile
     *
     * @param filepath
     */
    public RulesDatabase(String filepath) throws IOException {
        super(filepath+FILE_EXTENSION);
    }

    @Override
    public void _loadDB() throws IOException {
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
        r.setProduction(_db.file.readChar());
        r.description = _db.file.readLine();
        r.setEndOffset(_db.file.getFilePointer());
        return r;
    }

    /**
     * Deletes a rule from the file, leaving a trailing 0A for rule delimiting
     *
     * @param r Rule to erase
     * @return Always true, because it overwrites the rule section with 0's
     * @throws IOException
     */
    public boolean eraseRule(Rule r) throws IOException {
        compactDatabase(r.getStartOffset(), r.getEndOffset());
        _db.file.setLength(_db.file.getFilePointer());
        eof();
        return true;
    }


    /**
     * Writes a rule to the file at the current file pointer
     *
     * @param rule
     * @throws IOException
     */
    private void _writeRule(Rule rule) throws IOException {
        _db.file.writeByte(this.index); // Rule Number
        for (byte i = 0; i < Rule.MAX_RECORDS; i++) {
            _db.file.writeChar(rule.getRecord()[i]);
        }
        _db.file.writeChar(rule.getProduction());
        _db.file.writeChars(rule.getDescription());
    }

    /**
     * Adds a new rule to the database, at the EOF
     *
     * @param rule Rule to append
     */
    public void appendRule(Rule rule) throws IOException {
        eof();
        _writeRule(rule);
        this.index += 1;
        updateHeader();
    }

    /**
     * Reloads rules from the file.
     *
     * @param cached    - If the actual rules are a cache version or if all file must be re-read from disk
     */
    public void reloadRules(boolean cached){
//        if (cached){
//            rules.get(rules.) // TODO: Finish rule reload
//        } else {
//
//        }
    }

    /**
     * Updates a rule. This will always move the pointer to EOF
     *
     * @param r Rule to update
     * @throws IOException
     */
    public void updateRule(Rule r) throws IOException { // TODO: implement
        // Calculate new rule size
    }

}
