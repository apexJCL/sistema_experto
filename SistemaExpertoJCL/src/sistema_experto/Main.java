package sistema_experto;

import sistema_experto.entities.Database;
import sistema_experto.entities.Rule;

public class Main {

    public static void main(String[] args) throws Exception {
        Database db = new Database("test");
        Rule r = db.rules.get(2);
        System.out.println(r.description);
        db.close();
    }
}
