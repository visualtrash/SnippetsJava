import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Snippetun {
    public static void main(String[] args) throws Exception {
        SnippetService snippetService = new SnippetService();

        System.out.println("please enter the command");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userCommand = reader.readLine();     //ввод команды юзера

        if (userCommand.toUpperCase().equals("add".toUpperCase())) {        //add
            System.out.println("enter the name of snippet");
            String nameUserSnippet = reader.readLine();
            System.out.println("enter the text of snippet");
            String textUserSnippet = reader.readLine();
            snippetService.add(nameUserSnippet, textUserSnippet);
        }

    }
}
