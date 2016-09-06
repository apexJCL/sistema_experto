package sistema_experto.inference_motors;

import sistema_experto.entities.Fact;
import sistema_experto.entities.Resolution;
import sistema_experto.entities.Rule;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by José Carlos López on 04/09/2016.
 */
public class
ForwardChaining extends BaseMotor {

    private ArrayList<Fact> conflictSet = new ArrayList<Fact>(0);

    @Override
    public Resolution resolve() throws IOException {
        super.resolve();
        Resolution r = new Resolution();
        if (conflictSet.isEmpty()) {
            r.setSuccess(false);
            return r;
        }
        conflictSet = equate();
        while (!goalInFactsDatabase() && !conflictSet.isEmpty()) {
            conflictSet = equate();
            if (!conflictSet.isEmpty())
                solveConflictSet();
        }
        if (goalInFactsDatabase()) {
            r.setSuccess(true);
            r.setJustification(fdb.getJustification());
        }
        return r;
    }

    private void solveConflictSet() {
        for (Fact f: conflictSet){
            fdb.facts.add(f);
            conflictSet.remove(f);
        }
    }

    /**
     * Equates the facts with the rules.
     *
     * @return
     */
    @Override
    public ArrayList equate() {
        ArrayList<Fact> t = new ArrayList<>(0);
        String facts = _sortFacts();
        for (Rule r : kdb.rules) {
            if (!r.marked && facts.contains(r.recordAsString())) {
                r.marked = true;
                t.add(new Fact(r.getProduction(), r.description));
            }
        }
        return t;
    }

    /**
     * Sorts the facts of the fact database
     *
     * @return
     */
    private String _sortFacts() {
        char[] result = new char[fdb.facts.size()];
        for (int i = 0; i < fdb.facts.size(); i++)
            result[i] = fdb.facts.get(i).getIdentifier();
        return new String(Rule._sortRecord(result));
    }

    @Override
    public void setGoal(char g){
       
    }
}
