package sistema_experto.inference_motors;

import sistema_experto.entities.Database;
import sistema_experto.interfaces.InferenceMotor;

import java.io.IOException;
import java.util.ArrayList;
import sistema_experto.entities.FactsDatabase;
import sistema_experto.entities.Resolution;
import sistema_experto.entities.RulesDatabase;
import sistema_experto.entities.Fact;
import sistema_experto.entities.Rule;

/**
 * Created by José Carlos López on 29/08/2016.
 */
public class BackwardChaining implements InferenceMotor{

    private FactsDatabase fdb;
    private RulesDatabase kdb;

    private String factsPath;
    private String knowledgePath;
    private String justify;
    
    private ArrayList<Rule> conflictSet;
    private ArrayList<Character> NewGoals;

    private char goal = 0;

    public BackwardChaining(){
        conflictSet = new ArrayList<Rule>(0);
        NewGoals = new ArrayList<Character>(0);
        justify = "";
    }
  
    public boolean verify_goal(char p_meta){
        for (Fact hecho_actual : fdb.facts){
            if(hecho_actual.getIdentifier() == p_meta)
                return true;
        }
        return false;
    }
    
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
    public Resolution resolve()throws IOException{
        boolean respuesta = m_encadenar_atras(goal);
        Resolution answer = new Resolution(justify, respuesta);
        return answer;
        
        
    }
    public boolean m_encadenar_atras(char p_meta) throws IOException{
        boolean verified=false;
        if (verify_goal(p_meta)){
            System.out.println("META ALCANZADA DESDE LOS HECHOS INICIALES");
            justify = "META ALCANZADA DESDE LOS HECHOS INICIALES";
            return true;
        }else{
            conflictSet = equate(p_meta);                 //2,3,8
            while( !conflictSet.isEmpty()  && !verified ){
                Rule selected_rule = conflictSet.get(0);
                conflictSet.remove(selected_rule);
                NewGoals = m_extrarAntecedentes( selected_rule);      //d,g
                verified = true;
                
                while( !NewGoals.isEmpty() && verified){
                    char actual_goal = NewGoals.get(0);     //d
                    NewGoals.remove(actual_goal);
                    //verified = verify_goal(actual_goal);
                    verified = m_encadenar_atras(actual_goal);
                    
                    if(verified){
                        Fact new_fact = new Fact(actual_goal, "descripcion_hecho"); 
                        fdb.appendFact(new_fact);
                    }
                }
            }
            return verified;
        }
    }
    
    private ArrayList<Character> m_extrarAntecedentes(Rule p_selected_rule){
        ArrayList<Character> record = new ArrayList<>();
        char[] ch = p_selected_rule.getRecord();
       
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] != '-')
                record.add((Character) ch[i]);
        }
        return record;
    }
    @Override
    public void reloadFiles() {

    }

    @Override
    public ArrayList equate(char p_meta) {
        for(Rule r : kdb.rules){
            if(r.getProduction() == goal)
                conflictSet.add(r);
        }
        return conflictSet;
    }

    @Override
    public ArrayList equate() {
        return null;
    }

    @Override
    public void setGoal(char g){
       this.goal = g;
    }
}
