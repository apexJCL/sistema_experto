package sistema_experto.inference_motors;

import sistema_experto.entities.Fact;
import sistema_experto.entities.FactsDatabase;
import sistema_experto.entities.Resolution;
import sistema_experto.entities.RulesDatabase;
import sistema_experto.interfaces.InferenceMotor;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by José Carlos López on 05/09/2016.
 */
public class BaseMotor implements InferenceMotor {

    private String factsPath;
    private String knowledgePath;
    private boolean init = false;
    private char goal = 0;
    protected RulesDatabase kdb;
    protected FactsDatabase fdb;


    @Override
    public void init() throws IOException {
        this.fdb = new FactsDatabase(this.factsPath);
        this.kdb = new RulesDatabase(this.factsPath);
        init = true;
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
    public Resolution resolve() throws IOException {
        if (!init) init();
        return null;
    }

    @Override
    public void reloadFiles() throws IOException {

    }

    @Override
    public ArrayList equate() {
        return null;
    }

    @Override
    public void setGoal(char g) {
        this.goal = g;
    }

    /**
     * Returns if the fact database contains the actual goal
     * @return
     */
    boolean goalInFactsDatabase(){
        return this.fdb.facts.contains(new Fact(this.goal, "Goal"));
    }

}
