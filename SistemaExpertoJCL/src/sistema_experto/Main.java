package sistema_experto;

import sistema_experto.entities.Database;
import sistema_experto.entities.Rule;

public class Main {

    public static void main(String[] args) throws Exception {
        Database db = new Database("test");
        for (Rule r :
                db.rules) {
            System.out.println(r.description);
        }
//        db.eraseRule(db.rules.get(10));
//        Rule r = new Rule();
//        for (byte i = 0; i < 100; i++){
//            r.setRecord(new char[]{'a', 'b', 'c', 1, 1});
//            r.setProduction((byte) 9);
//            r.setDescription("Regla "+i+"\n");
//            db.appendRule(r);
//        }
        db.close();
    }
}
