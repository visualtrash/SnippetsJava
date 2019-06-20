import java.util.Date;
import java.util.UUID;

/**
 * Этот класс описывает структуру хранимого куска кода
 */
public class Snippet {

    private String name;
    private String text;
    private Date creationDate;
    private UUID id;

    /**
     * @param name наименование снипета
     * @param text текст сохраняемого кода
     */
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

