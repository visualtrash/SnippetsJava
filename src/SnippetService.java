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
            } else System.err.print("cannot find snippet");
        }
        return result;
    }

    public void update(UUID id, String name, String text) {
        for (int i = 0; i < listOfSnippets.size(); i++) {
            if(listOfSnippets.get(i).getId().equals(id)) {
                listOfSnippets.get(i).setText(text);
                listOfSnippets.get(i).setName(name);
                System.out.println("snippet has been update successful");
            } else System.err.print("cannot find snippet for this ID");
        }

    }

    public void remove(UUID id) {
        for (int i = 0; i < listOfSnippets.size(); i++) {
            if(listOfSnippets.get(i).getId().equals(id)) {
                listOfSnippets.remove(listOfSnippets.get(i));
                System.out.println("snippet has been delete successful");
            } else System.err.print("cannot find snippet for this ID");
        }
    }

}



