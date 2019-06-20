import java.util.Date;
import java.util.UUID;

public class Snippet {
    private String name;
    private String text;
    private Date creationDate;
    private UUID id;

    Snippet(String name, String text) {
        this.name = name;
        this.text = text;

        this.id = UUID.randomUUID();
        this.creationDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getId() {
        return id;
    }
}

