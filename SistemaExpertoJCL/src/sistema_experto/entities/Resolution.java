package sistema_experto.entities;

/**
 * Created by José Carlos López on 05/09/2016.
 */
public class Resolution {

    private String justification;
    private boolean success;

    /**
     * Creates a new Resolution Object, that contains an array of characters (ordered) in how the
     * expert system reached (or not) a goal.
     * Also includes a boolean to check if the goal was achieved
     *
     * @param justification
     * @param success
     */
    public Resolution(String justification, boolean success){
        this.justification = justification;
        this.success = success;
    }

    public String getJustification() { return justification; }

    }

    public ArrayList<Character> getJustification() { return justification; }
    public boolean sucess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
}
