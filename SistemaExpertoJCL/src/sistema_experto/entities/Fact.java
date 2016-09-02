package sistema_experto.entities;

/**
 * Created by José Carlos López on 01/09/2016.
 */
public class Fact {

    private char identifier;
    private String description;

    // File properties
    private long startOffset;
    private long endOffset;

    public Fact(char identifier, String description){
        this.identifier = identifier;
        this.description = description;
    }

    public char getIdentifier() { return identifier; }

    public void setIdentifier(char identifier) { this.identifier = identifier; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public long getStartOffset() { return startOffset; }

    public void setStartOffset(long startOffset) { this.startOffset = startOffset; }

    public long getEndOffset() { return endOffset; }

    public void setEndOffset(long endOffset) { this.endOffset = endOffset; }
}
