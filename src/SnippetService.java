import java.util.List;
import java.util.UUID;

public class SnippetService {
    private List listOfSnippets;

    public Object add(String name, String text) {
        return new Object();
    }
    
    public List find(String searchString) {
        return null;
    }

    public boolean edit(Object snippet) {
        return true;
    }

    public boolean remove(UUID id) {
        return true;
    }
}
