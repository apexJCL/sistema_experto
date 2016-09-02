package sistema_experto.entities;

import java.io.IOException;

/**
 * Created by José Carlos López on 01/09/2016.
 */
public class FactsDatabase extends Database {

    private static final String FILE_EXTENSION = ".fdb";

    /**
     * Creates (or opens) a new "Database" based on a RandomAccessFile
     *
     * @param filepath
     */
    public FactsDatabase(String filepath) throws IOException {
        super(filepath);
    }

    @Override
    public void _loadDB() throws IOException {
        super._loadDB();
    }

    /**
     * Writes a fact at the current file pointer
     *
     * @param fact
     * @throws IOException
     */
    public void _writeFact(Fact fact) throws IOException {
        _db.file.writeByte(fact.getIdentifier());
        _db.file.writeChars(fact.getDescription());
    }

    /**
     * Appends a fact to the database
     *
     * @param fact
     * @throws IOException
     */
    public void appendFact(Fact fact) throws IOException {
        eof();
        _writeFact(fact);
        index+=1;
        updateHeader();
    }
}
