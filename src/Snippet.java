import java.util.Date;
import java.util.UUID;

public class Snippet {
    private String name;
    private String text;
    private Date date;
    private UUID id;

    Snippet (String name, String text) {
        this.name = name;
        this.text= text;
    }
}
