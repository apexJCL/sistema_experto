package sistema_experto.entities;

/**
 * Class that defines a basic rule for a RBS
 * <p>
 * Rule number = byte
 * Record = char[5]
 * Production = char
 * <p>
 * Total size of a rule: 14 bytes + String
 */
public class Rule {

    // Rule generic status
    public static byte MAX_RECORDS = 5;
    public boolean marked;
    // Rule properties
    private byte ruleNumber;
    private char[] record;
    private byte production;
    public String description;

    public Rule() {
        record = new char[MAX_RECORDS];
        for (byte i = 0; i < MAX_RECORDS; i++)
            record[i] = 0;
        marked = false;
        description = "";
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
        marked = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRuleNumber(byte ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    public void setRecord(char[] record) throws Exception {
        if (record.length > 5)
            throw new Exception("Production can't be more than 5");
        this.record = record;
    }

    public void setProduction(byte production) {
        this.production = production;
    }

    public char[] getRecord() {
        return record;
    }

    public byte getRuleNumber() {
        return ruleNumber;
    }

    public byte getProduction() {
        return production;
    }

    public String getDescription() { return description; }
}
