import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Snippetun {
    public static void main(String[] args) throws Exception {
        SnippetService snippetService = new SnippetService();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("please enter the command");
            String userCommand = reader.readLine();     //ввод команды юзера

            if (userCommand.toUpperCase().equals("add".toUpperCase())) {        //add
                System.out.println("enter the name of snippet");
                String nameUserSnippet = reader.readLine();
                //System.out.println("1");
                System.out.println("enter the text of snippet");
                String textUserSnippet = reader.readLine();
                //System.out.println("2");
                snippetService.add(nameUserSnippet, textUserSnippet);
                System.out.println("snippet was successfully added");

            }
            if (userCommand.toUpperCase().equals("EXIT")) break;

        }
        //System.out.println("3");
    }
}
