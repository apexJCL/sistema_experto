package sistema_experto;

import sistema_experto.entities.*;
import sistema_experto.inference_motors.ForwardChaining;
import sistema_experto.ui.UpdateModule;

public class Main {

    public static void main(String[] args) throws Exception {
        ForwardChaining fc = new ForwardChaining();
        fc.setKnowledgePath("rules");
        fc.setFactsPath("facts");
        fc.init();
    }
}
