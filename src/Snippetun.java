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
        } else if (userCommand.toUpperCase().equals("find".toUpperCase())) {        //find
            System.out.println("enter the keyword or something");
            String searchField = reader.readLine();
            snippetService.find(searchField);
        } else if (userCommand.toUpperCase().equals("update".toUpperCase())) {      //update ??
            System.out.println("what do u want to update? (NAME / TEXT)");
            String userUpdateChoise = reader.readLine();
            if (userUpdateChoise.toUpperCase().equals("NAME")) {
                System.out.println("enter new name");
                String newName = reader.readLine();

            } else if (userUpdateChoise.toUpperCase().equals("TEXT")) {

            } else System.out.println("wrong command");
        } else if (userCommand.toUpperCase().equals("REMOVE")) {        //remove ??
            System.out.println();
        }

    }
}
