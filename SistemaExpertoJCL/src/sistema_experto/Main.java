package sistema_experto;

import sistema_experto.entities.Database;
import sistema_experto.entities.Rule;

public class Main {

    public static void main(String[] args) throws Exception {
        Rule r = new Rule();
        char[] test = {'x', 'a', 'e', 'b', 'o'};
        r.setRecord(test);
        for (char c: r.getRecord())
            System.out.print(c);
    }
}
