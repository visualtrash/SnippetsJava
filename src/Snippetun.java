import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Snippetun {
    public static final String savedDataFileName = "snippetun.txt";

    public static void main(String[] args) throws Exception {
        SnippetService snippetService = new SnippetService(savedDataFileName);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        outerCycle:
        while (true) {
            // ввод команды юзера
            System.out.println("please enter the command");
            String userCommand = reader.readLine().toUpperCase();

            switch (userCommand) {
                case Commands.ADD_COMMAND:
                    System.out.println("enter the name of snippet");
                    String nameUserSnippet = reader.readLine();

                    System.out.println("enter the text of snippet");
                    String textUserSnippet = reader.readLine();

                    snippetService.add(nameUserSnippet, textUserSnippet);
                    System.out.println("snippet was successfully added\n");
                    break;
                case Commands.FIND_COMMAND:
                    //todo
                    break;
                case Commands.REMOVE_COMMAND:
                    //todo
                    break;
                case Commands.UPDATE_COMMAND:
                    //todo
                    break;
                case Commands.EXIT_COMMAND:
                    break outerCycle;
            }
        }

        snippetService.persist(savedDataFileName);
    }
}
