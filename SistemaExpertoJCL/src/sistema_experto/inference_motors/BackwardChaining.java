package sistema_experto.inference_motors;

import sistema_experto.entities.Database;

import java.io.IOException;

/**
 * Created by José Carlos López on 29/08/2016.
 */
public class BackwardChaining {

    private Database knowledgeDatabase;
    private boolean verified;

    public BackwardChaining() throws IOException {
        knowledgeDatabase = new Database("BH");
        verified = false;
    }

    public Database process(Database factsDatabase){

        return factsDatabase;
    }


    private boolean _metaEnBH(){
        return true; // TODO implement
    }
}
