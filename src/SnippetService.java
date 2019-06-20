import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SnippetService {
    private List<Snippet> listOfSnippets = new ArrayList<>();

    public Snippet add(String name, String text) {

        Snippet snippet = new Snippet(name,text);
        listOfSnippets.add(snippet);
        return snippet;
    }

    public Snippet find(String searchString) {
        Snippet result = null;
        for (int i = 0; i < listOfSnippets.size(); i++) {
            if (listOfSnippets.get(i).getName().contains(searchString)) {
                result = listOfSnippets.get(i);
            }
        }
        return result;
    }

    public boolean update(UUID id, String name, String text) {
        for (int i = 0; i < listOfSnippets.size(); i++) {
            if(listOfSnippets.get(i).getId().equals(id)) {
                
            }
        }
        return true;
    }

    public boolean remove(UUID id) {
        return true;
    }

}


