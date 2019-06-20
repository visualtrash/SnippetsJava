import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SnippetService {
    private List<Snippet> listOfSnippets = new ArrayList<>();

    public Object add(String name, String text) {
        return new Object();
    }

    public List find(String searchString) {
        return null;
    }

    public boolean update(UUID id, String name, String text) {
        return true;
    }

    public boolean remove(UUID id) {
        return true;
    }
}
