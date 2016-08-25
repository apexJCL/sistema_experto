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
    /**
     * This ones are for inner file handling, to correctly erase a rule from the file, given it's starting point and
     * ending point.
     * THIS MUST BE SET WHEN RULES ARE BEING LOADED
     */
    private long START_OFFSET;
    private long END_OFFSET;

    public Rule() {
        record = new char[MAX_RECORDS];
        for (byte i = 0; i < MAX_RECORDS; i++)
            record[i] = 0;
        marked = false;
        description = "";
    }

    public Rule(char[] record, byte production) {
        super();
        this.record = record;
        this.production = production;
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

    public String getDescription() {
        return description;
    }

    public long getStartOffset() {
        return START_OFFSET;
    }

    public void setStartOffset(long START_OFFSET) {
        this.START_OFFSET = START_OFFSET;
    }

    public long getEndOffset() {
        return END_OFFSET;
    }

    public void setEndOffset(long END_OFFSET) {
        this.END_OFFSET = END_OFFSET;
    }

}
