package sistema_experto.entities;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by José Carlos López on 01/09/2016.
 */
public class FactsDatabase extends Database {

    private static final String FILE_EXTENSION = ".fdb";
    public ArrayList<Fact> facts;
    private String justification;

    /**
     * Creates (or opens) a new "Database" based on a RandomAccessFile
     *
     * @param filepath
     */
    public FactsDatabase(String filepath) throws IOException {
        super(filepath+FILE_EXTENSION);
    }

    @Override
    public void _loadDB() throws IOException {
        index = this._db.file.readByte();
        facts = new ArrayList<>(index);
        while(!_db.isEOF())
            facts.add(new Fact(_db.file.readChar(), _db.file.readLine()));
        eof();
    }

    /**
     * Writes a fact at the current file pointer
     *
     * @param fact
     * @throws IOException
     */
    private void _writeFact(Fact fact) throws IOException {
        _db.file.writeChar(fact.getIdentifier());
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

    /**
     * Deletes a fact from the database
     *
     * @param fact
     * @throws IOException
     */
    public void eraseFact(Fact fact) throws IOException {
        compactDatabase(fact.getStartOffset(), fact.getEndOffset());
        _db.file.setLength(_db.file.getFilePointer());
        eof();
    }

    /**
     * Reloads the file database again
     *
     * @throws IOException
     */
    public void reloadFacts() throws IOException {
        facts.clear();
        _loadDB();
    }

    public String getJustification() {
        String justification = "";
        for (int i = 0; i < justification.length(); i++)
            justification += (i+1 == justification.length()) ? facts.get(i).getIdentifier() : facts.get(i).getIdentifier() + "->";
        return justification;
    }
}