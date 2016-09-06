package sistema_experto.inference_motors;

import sistema_experto.entities.FactsDatabase;
import sistema_experto.entities.Resolution;
import sistema_experto.entities.RulesDatabase;
import sistema_experto.interfaces.InferenceMotor;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by José Carlos López on 04/09/2016.
 */
public class ForwardChaining implements InferenceMotor {

    private FactsDatabase fdb;
    private RulesDatabase kdb;
    private String factsPath;
    private String knowledgePath;
    private ArrayList<Character> conflictSet = new ArrayList<Character>(0);

    @Override
    public void init() throws IOException {
        this.fdb = new FactsDatabase(this.factsPath);
        this.kdb = new RulesDatabase(this.factsPath);
    }

    @Override
    public void setFactsPath(String path) {
        this.factsPath = path;
    }

    @Override
    public void setKnowledgePath(String path) {
        this.knowledgePath = path;
    }

    @Override
    public Resolution resolve() {
        return null;
    }

    @Override
    public void reloadFiles() {

    }

    @Override
    public ArrayList equate() {

        return null;
    }

    @Override
    public void setGoal(char g){
       
    }
}
