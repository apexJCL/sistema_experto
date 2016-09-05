package sistema_experto.entities;

/**
 * Created by José Carlos López on 05/09/2016.
 */
public class Resolution {

    private char[] justification;
    private boolean success;

    /**
     * Creates a new Resolution Object, that contains an array of characters (ordered) in how the
     * expert system reached (or not) a goal.
     * Also includes a boolean to check if the goal was achieved
     *
     * @param justification
     * @param success
     */
    public Resolution(char[] justification, boolean success){
        this.justification = justification;
        this.success = success;
    }

    public char[] getJustification() { return justification; }

    public boolean isSuccess() { return success; }
}
