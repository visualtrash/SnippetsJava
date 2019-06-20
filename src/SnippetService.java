import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class SnippetService {

    private List<Snippet> listOfSnippets = new ArrayList<>();

    public Snippet add(String name, String text) {
        Snippet snippet = new Snippet(name, text);

        listOfSnippets.add(snippet);

        return snippet;
    }

    /**
     * Найти снипеты в списке, по тексту в их названии
     * @param searchString строка, которую должно включаться в себя название искомого снипета
     * @return*/
    public List<Snippet> find(String searchString) {
        // список снипетов, которые мы нашли по имени
        List<Snippet> findedSnippets = new ArrayList<>();

        for (Snippet currentSnippet : listOfSnippets) {
            // мы взяли текущий снипет из списка, конвертировали его имя в Upper Case и смотрим включает ли оно строку поиска, которая тоже конвертирована в Upper Case
            if (currentSnippet.getName().toUpperCase().contains(searchString.toUpperCase())){
                findedSnippets.add(currentSnippet);
            }
        }

        return findedSnippets;
    }

    public void update(UUID id, String name, String text) throws Exception {
         // флаг, обозначающий был ли найден сниппет в списке
         boolean snippetWasFounded = false;

        for (Snippet currentSnippet : listOfSnippets) {
            if (currentSnippet.getId().equals(id)){
                snippetWasFounded = true;

                currentSnippet.setName(name);
                currentSnippet.setText(text);
                break;
            }
        }

        if (!snippetWasFounded){
            throw new Exception("Cannot find snippet for ID = " + id);
        }
    }

    public void remove(UUID id) throws Exception {
        // флаг, обозначающий был ли найден сниппет в списке
        boolean snippetWasFounded = false;

        for (Snippet currentSnippet : listOfSnippets) {
            if (currentSnippet.getId().equals(id)){
                snippetWasFounded = true;

                listOfSnippets.remove(currentSnippet);
                break;
            }
        }

        if (!snippetWasFounded){
            throw new Exception("Cannot find snippet for ID = " + id);
        }
    }

}



