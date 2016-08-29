package sistema_experto.inference_motors;

import sistema_experto.common.RandomIO;
import sistema_experto.entities.Rule;

import java.io.IOException;
import java.util.ArrayList;

import static sistema_experto.common.RandomIO.FileMode.RW;

/**
 * Created by José Carlos López on 23/08/2016.
 */
public class ForwardChaining {

    private RandomIO kdb; // Knowledge Database
    public ArrayList<Rule> rules = new ArrayList<>(0);


    /**
     * Creates a new instance of Forward Chaining inference motor
     *
     * @param kdbPath - File path for previously stored (or new) Knowledge Database
     * @param fdbPath - File path for previously stored (or new) Facts Database
     * @throws IOException if any of the given paths couldn't be found or created
     */
    public ForwardChaining(String kdbPath, String fdbPath) throws IOException {
        this.kdb = new RandomIO(kdbPath, RW, true);
    }


    /**
     * Loads rules from the file
     *
     * @throws IOException
     */
    public void loadRules() throws IOException {
        kdb.file.seek(0); // Resets file position (if applies)
        while (kdb.file.getFilePointer() <= kdb.getSize()) {
            Rule r = new Rule();  // Creates new rule
            r.setRuleNumber(kdb.file.readByte()); // Sets production
            for (byte i = 0; i < Rule.MAX_RECORDS; i++) {
                r.getRecord()[i] = kdb.file.readChar(); // Moves 2 bytes into the char
            }
            r.setProduction(kdb.file.readByte());
        }
    }

}
