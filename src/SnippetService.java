import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SnippetService {
    private List<Snippet> listOfSnippets = new ArrayList<>();

    public Object add(String name, String text) {

        Snippet snippet = new Snippet("snippet","someCode");
        listOfSnippets.add(snippet);
        return snippet;
    }

    public Snippet find(String searchString) {
        Snippet result = null;
        for (int i = 0; i < listOfSnippets.size(); i++) {
            if (listOfSnippets.contains(searchString)) {
                result = listOfSnippets.get(i);
            }
        }
        return result;
    }

    public boolean update(UUID id, String name, String text) {
        for (int i = 0; i < listOfSnippets.size(); i++) {
            if (id.equals()
        }
        return true;
    }

    public boolean remove(UUID id) {
        return true;
    }
    
}

