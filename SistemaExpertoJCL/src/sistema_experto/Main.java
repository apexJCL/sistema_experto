package sistema_experto;

import sistema_experto.entities.Database;
import sistema_experto.entities.Rule;

public class Main {

    public static void main(String[] args) throws Exception {
        Database db = new Database("test");
        char[] record = {'a', 'b', 'c', 'd', 0};
        byte number = 10;
        byte production = 9;
        Rule r = new Rule(number, record, production);
        r.setDescription("Regla 1\n");
        db.appendRule(r);
        System.exit(0);
    }
}
