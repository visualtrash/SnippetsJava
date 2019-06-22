import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class SnippetService {

    private List<Snippet> listOfSnippets;

    public Snippet add(String name, String text) {
        Snippet snippet = new Snippet(name, text);

        listOfSnippets.add(snippet);

        return snippet;
    }

    /**
     * @param filePath путь к файлу из которого нужно загрузить список снипетов
     */
    public SnippetService(String filePath) {
        listOfSnippets = loadSnippetsFromDisc(filePath);
    }

    // todo написать для этого метода команду в консоли

    /**
     * Найти снипеты в списке, по тексту в их названии
     *
     * @param searchString строка, которую должно включаться в себя название искомого снипета
     * @return
     */
    public List<Snippet> find(String searchString) {
        // список снипетов, которые мы нашли по имени
        List<Snippet> findedSnippets = new ArrayList<>();

        for (Snippet currentSnippet : listOfSnippets) {
            // мы взяли текущий снипет из списка, конвертировали его имя в Upper Case и смотрим включает ли оно строку поиска, которая тоже конвертирована в Upper Case
            if (currentSnippet.getName().toUpperCase().contains(searchString.toUpperCase())) {
                findedSnippets.add(currentSnippet);
            }
        }

        return findedSnippets;
    }

    /**
     * @return все добавленные снипеты
     */
    public void getAll() {
        for (Snippet snippetOfList : listOfSnippets) {
            System.out.println("NAME: " + snippetOfList.getName());
            System.out.println("--------------------------------");
            System.out.println("ID: " + snippetOfList.getId());
            System.out.println("--------------------------------");
            System.out.println("TEXT: " + snippetOfList.getText());
        }

    }

    // todo разбить на 2 метода - 1) обновить имя снипета 2) обновиить текст снипета
    // todo для них сделать 2 разные команды для консоли
    //изменение имени
    public void updateName(UUID id, String name, String text) throws Exception {
        // флаг, обозначающий был ли найден сниппет в списке
        boolean snippetWasFounded = false;

        for (Snippet currentSnippet : listOfSnippets) {
            if (currentSnippet.getId().equals(id)) {
                snippetWasFounded = true;

                currentSnippet.setName(name);

                break;
            }
        }

        if (!snippetWasFounded) {
            throw new Exception("Cannot find snippet for ID = " + id);
        }
    }

    // изменение текста
    public void updateText(UUID id, String name, String text) throws Exception {
        // флаг, обозначающий был ли найден сниппет в списке
        boolean snippetWasFounded = false;

        for (Snippet currentSnippet : listOfSnippets) {
            if (currentSnippet.getId().equals(id)) {
                snippetWasFounded = true;


                currentSnippet.setText(text);
                break;
            }
        }

        if (!snippetWasFounded) {
            throw new Exception("Cannot find snippet for ID = " + id);
        }
    }

    public void remove(UUID id) throws Exception {
        // флаг, обозначающий был ли найден сниппет в списке
        boolean snippetWasFounded = false;

        for (Snippet currentSnippet : listOfSnippets) {
            if (currentSnippet.getId().equals(id)) {
                snippetWasFounded = true;

                listOfSnippets.remove(currentSnippet);
                break;
            }
        }

        if (!snippetWasFounded) {
            throw new Exception("Cannot find snippet for ID = " + id);
        }
    }

    /**
     * Сохранить коллекцию снипетов в файл на диск
     */
    public void persist() {
    }

    /**
     * Инициализировать коллекцию снипетов считав сериализованный список снипетов из файла
     */
    private List<Snippet> loadSnippetsFromDisc(String filePath) {
        return new ArrayList<>();
    }

}



