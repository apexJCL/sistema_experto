package sistema_experto.entities;

import java.util.ArrayList;

/**
 * Class that defines a basic rule for a RBS
 * <p>
 * Rule number = byte
 * Record = char[5]
 * Production = char
 * <p>
 * Total size of a rule: 14 bytes + String
 * <p>
 * About constants:
 * <p>
 * Max records: Max amount of records in the char array
 * Base rule size: Basic rule size dependant of the:
 * - Rule number
 * - Record array
 * - Production
 * This amounts to a total of 14 bytes
 * Null Byte: We mark a non valid
 */
public class Rule {

    // Rule generic status
    public static byte MAX_RECORDS = 5;
    public static byte BASE_RULE_SIZE = 14;

    public boolean marked;
    // Rule properties
    private byte ruleNumber;
    private char[] record;
    private char production;
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

    public Rule(char[] record, char production) {
        super();
        this.record = record;
        this.production = production;
        _sortRecord();
    }

    private void _sortRecord(){
        this.record = _sortRecord(record);
    }

    /**
     * Sorts a record in alphabetical order using insertion sort
     * @param record
     * @return
     */
    public static char[] _sortRecord(char[] record) {
        for (byte i = 1; i < record.length; i++) {
            byte j = i;
            while (j > 0 && record[j - 1] > record[j]) {
                record[j - 1] = (char) (record[j - 1] ^ record[j]);
                record[j] = (char) (record[j] ^ record[j - 1]);
                record[j - 1] = (char) (record[j - 1] ^ record[j]);
                j -= 1;
            }
        }
        return record;
    }

    /**
     * Creates a new rule with a position number, a record array and a production char.
     *
     * @param number     Rule number
     * @param record     Record array
     * @param production Production
     * @throws Exception If the record array exceeds maximum size (5)
     */
    public Rule(byte number, char[] record, char production) throws Exception {
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
        _sortRecord();
    }

    public void setProduction(char production) {
        this.production = production;
    }

    public char[] getRecord() {
        return record;
    }

    public byte getRuleNumber() {
        return ruleNumber;
    }

    public char getProduction() {
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

    /**
     * Preferrable method to assign a value to a record.
     * <p>
     * We use this because we only need printable characters on the char array, we mark 'empty' as 0
     *
     * @param index
     * @param value
     */
    public void setRecord(byte index, char value) {
        this.record[index] = value;
    }

    /**
     * Returns the records of a rule as a string
     * @return
     */
    public String recordAsString(){
        String t = "";
        for (char c: record)
            t += c != 0 ? c : "";
        return t;
    }

}
