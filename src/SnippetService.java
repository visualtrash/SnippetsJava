import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class SnippetService {

    private List<Snippet> listOfSnippets;

    /**
     * @param filePath путь к файлу из которого нужно загрузить список снипетов
     */
    public SnippetService(String filePath) throws IOException, ParseException {
        File savedDataFile = new File(filePath);
        // if file already exists will do nothing
        savedDataFile.createNewFile();

        listOfSnippets = loadSnippetsFromDisc(savedDataFile);
    }

    public Snippet add(String name, String text) {
        Snippet snippet = new Snippet(name, text);

        listOfSnippets.add(snippet);

        return snippet;
    }

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
            System.out.println(findedSnippets);

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
            System.out.println("TEXT: " + snippetOfList.getText() + "\n");
        }

    }

    public void updateName(UUID id, String name) throws Exception {
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


    public void updateText(UUID id, String text) throws Exception {
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
    public void persist(String fileName) throws IOException {
        String result = "";

        for (Snippet currentSnippet : listOfSnippets) {
            String currentSnippetLine =
                    currentSnippet.getName() + "<|>" + currentSnippet.getText() + "<|>" +
                            currentSnippet.getId() + "<|>" + currentSnippet.getCreationDate().getTime();
            result += currentSnippetLine + "\n";
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName, false);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        bufferedWriter.write(result);
        bufferedWriter.close();
    }

    /**
     * Инициализировать коллекцию снипетов считав сериализованный список снипетов из файла
     */
    private List<Snippet> loadSnippetsFromDisc(File savedDataFile) throws IOException, ParseException {

        FileInputStream fileInputStream = new FileInputStream(savedDataFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String fileLine;
        ArrayList<Snippet> listOfSnippets = new ArrayList<>();

        while ((fileLine = bufferedReader.readLine()) != null) {
            String[] snippetParamsArray = fileLine.split("<\\|>");
            String name = snippetParamsArray[0];
            String text = snippetParamsArray[1];
            String idString = snippetParamsArray[2];
            UUID id = UUID.fromString(idString);
            String dateString = snippetParamsArray[3];
            Date date = new Date(Long.parseLong(dateString));

            Snippet snippet = new Snippet(name, text, id, date);
            listOfSnippets.add(snippet);
        }
        return listOfSnippets;
    }
}



