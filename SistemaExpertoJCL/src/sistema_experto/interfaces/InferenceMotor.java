package sistema_experto.interfaces;

import sistema_experto.entities.Resolution;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by José Carlos López on 05/09/2016.
 */
public interface InferenceMotor {

    boolean init = false;
    char goal = 0;

    /**
     * Meant to be called after setting up all the paths and before resolve.
     * It will be called either way in resolve and evaluated if it was not initiated previously.
     */
    void init() throws IOException;

    /**
     * Sets the path of the facts database.
     * If exists, it will load it,
     * else, it will create the file.
     *
     * @param path
     */
    void setFactsPath(String path);

    /**
     * Sets the path of the knowledge database,
     * If exists, it will load it,
     * else it will create the file.
     *
     * @param path
     */
    void setKnowledgePath(String path);

    /**
     * Resolves the actual issue given a correct setup of the knowledge and facts database
     *
     * @return A Resolution object that contains a justification and if the process was successful or not
     */
    Resolution resolve() throws IOException;

    /**
     * Reloads the database files
     */
    void reloadFiles();

    /**
     * Equates the facts with the rules and returns a conflict set
     * @return Conflict set
     */
    ArrayList equate(char p_meta);

    /**
    * Sets the current goal
    */
    void setGoal(char g);

}