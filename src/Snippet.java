import java.util.Date;
import java.util.UUID;

public class Snippet {
    private String name;
    private String text;
    private Date date = new Date();
    private UUID id = UUID.randomUUID();

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
    public void setId(UUID id) {
        this.id = id;
    }
    
    Snippet (String name, String text) {
        this.name = name;
        this.text= text;
    }
}

