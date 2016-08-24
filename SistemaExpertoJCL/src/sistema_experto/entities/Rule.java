package sistema_experto.entities;

/**
 * Class that defines a basic rule for a RBS
 * <p>
 * Rule number = byte
 * Record = char[5]
 * Production = char
 */
public class Rule {

    private byte ruleNumber;
    private char[] record;
    private byte production;
    public static byte MAX_RECORDS = 5;
    public static String description;

    public Rule() {
        record = new char[]{0, 0, 0, 0, 0};
    }

    /**
     * Creates a new rule with a position number, a record array and a production char.
     *
     * @param number     Rule number
     * @param record     Record array
     * @param production Production
     * @throws Exception If the record array exceeds maximum size (5)
     */
    public Rule(byte number, char[] record, byte production) throws Exception {
        if (record.length > 5)
            throw new Exception("Production only can be 5 or less");
        this.ruleNumber = number;
        this.record = new char[]{0, 0, 0, 0, 0};
        this.record = record;
        this.production = production;
    }

    public void setRuleNumber(byte ruleNumber) { this.ruleNumber = ruleNumber; }

    public void setRecord(char[] record) throws Exception {
        if (record.length > 5)
            throw new Exception("Production can't be more than 5");
        this.record = record;
    }

    public void setProduction(byte production) { this.production = production; }

    public char[] getRecord() {
        return record;
    }

    public byte getRuleNumber() { return ruleNumber; }

    public byte getProduction() { return production; }


}
