import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Snippetun {
    public static void main(String[] args) throws Exception {
        SnippetService snippetService = new SnippetService("snippetun.bin");


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            // ввод команды юзера
            System.out.println("please enter the command");
            String userCommand = reader.readLine();

            // add
            if (userCommand.toUpperCase().equals("add".toUpperCase())) {
                System.out.println("enter the name of snippet");
                String nameUserSnippet = reader.readLine();

                System.out.println("enter the text of snippet");
                String textUserSnippet = reader.readLine();

                snippetService.add(nameUserSnippet, textUserSnippet);
                System.out.println("snippet was successfully added");

            }
            if (userCommand.toUpperCase().equals("EXIT")) break;
        }
        snippetService.persist();
    }
}
