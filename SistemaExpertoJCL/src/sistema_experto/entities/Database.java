package sistema_experto.entities;

import sistema_experto.common.RandomIO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by José Carlos López on 23/08/2016.
 */
public class Database {

    private static byte HEADER_SIZE = 1;
    protected RandomIO _db;
    protected byte index = 0;

    /**
     * Creates (or opens) a new "Database" based on a RandomAccessFile
     *
     * @param filepath
     */
    public Database(String filepath) throws IOException {
        this._db = new RandomIO(filepath, RandomIO.FileMode.RW, true);
        if (this._db.newFile) {
            _initDB();
        } else _loadDB();
    }

    /**
     * Loads the DB Header from the file and sets the default parameters.
     * It loads each rule that appears after the header and until the EOF
     */
    public void _loadDB() throws IOException {
        index = this._db.file.readByte();
        eof();
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
     *
     * @throws IOException
     */
    public void eof() throws IOException {
        this._db.file.seek(this._db.getSize());
    }

    /**
     * Returns the number of the last inserted rule
     *
     * @return
     */
    public long getIndex() {
        return index;
    }

    /**
     * Compacts the database when a rule has been erased. DOES NOT RETURN FILE POINTER
     *
     * @param startOffset - Start offset of the rule
     * @param endOffset   - End offset of the rule
     * @throws IOException
     */
    protected void compactDatabase(long startOffset, long endOffset) throws IOException {
        long limit = _db.getSize();
        byte t = 0;
        while (endOffset < limit) {
            _db.file.seek(endOffset);
            t = _db.file.readByte();
            endOffset = _db.file.getFilePointer();
            _db.file.seek(startOffset);
            _db.file.writeByte(t);
            startOffset = _db.file.getFilePointer();
        }
    }

    public void close() throws IOException {
        _db.dispose();
    }

}
