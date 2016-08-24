package sistema_experto.entities;

import sistema_experto.common.RandomIO;

import java.io.IOException;

/**
 * Created by José Carlos López on 23/08/2016.
 */
public class Database {

    private RandomIO _db;
    private long index = 0;
    private long rules = 0;

    /**
     * Creates (or opens) a new "Database" based on a RandomAccessFile
     *
     * @param filepath
     */
    public Database(String filepath) throws IOException {
        this._db = new RandomIO(filepath, RandomIO.FileMode.RW, true);
        if (this._db.newFile)
            _initDB();
        else _loadDB();
    }

    /**
     * Loads the DB Header from the file and sets the default parameters
     *
     */
    private void _loadDB() throws IOException {
        this.index = this._db.file.readLong();
        this.rules = this._db.file.readLong();
        this._db.file.seek(17);
    }

    /**
     * This method initializes a database with a default header that includes
     * - Amount of rules in the database (Long)
     * - Last used key (for sequential addon) (Long)
     * - New Line
     * Total header size: 17 bytes
     */
    private void _initDB() throws IOException {
        this._db.file.writeLong(0L);
        this._db.file.writeLong(0L);
        this._db.file.writeChar('\n');
    }

    /**
     * Adds a new rule to the database, at the EOF
     *
     * @param rule Rule to append
     */
    public void appendRule(Rule rule) {

    }

}
