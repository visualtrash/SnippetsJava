import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.UUID;


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
                    // add text
                    System.out.println("enter the text of snippet");
                    String textUserSnippet = reader.readLine();
                    // add name
                    snippetService.add(nameUserSnippet, textUserSnippet);
                    System.out.println("snippet was successfully added\n");
                    break;
                case Commands.FIND_COMMAND:
                    snippetService.getAll();
                    System.out.println("enter the snippet name to find");
                    String enterFindString = reader.readLine();
                    snippetService.find(enterFindString);
                    break;
                case Commands.REMOVE_COMMAND:
                    System.out.println("enter ID of snippet for remove");
                    String enterIdRemove = reader.readLine();
                    UUID idRemove = UUID.fromString(enterIdRemove);

                    snippetService.remove(idRemove);
                    System.out.println("snippet was successfully removed\n");
                    break;
                case Commands.UPDATE_COMMAND:
                    System.out.println("what do u want to update (NAME/TEXT)?");
                    String userUpdateCommand = reader.readLine();
                    String enterId;

                    while (true) {
                        if (userUpdateCommand.toUpperCase().equals("NAME")) {
                            System.out.println("enter ID of snippet to update");
                            enterId = reader.readLine();
                            UUID id = UUID.fromString(enterId);
                            System.out.println("enter new NAME of snippet to update");
                            String name = reader.readLine();

                            snippetService.updateName(id, name);
                            System.out.println("snippet was successfully updated\n");
                            break;
                        } else if (userUpdateCommand.toUpperCase().equals("TEXT")) {
                            System.out.println("enter ID of snippet to update");
                            enterId = reader.readLine();
                            System.out.println("enter new TEXT of snippet to update");
                            String text = reader.readLine();
                            UUID id = UUID.fromString(enterId);

                            snippetService.updateText(id, text);
                            System.out.println("snippet was successfully updated\n");
                            break;
                        } else System.out.println("unknown command. be carefully next time"); break;
                    }
                case Commands.EXIT_COMMAND:
                    break outerCycle;
            }
        }

        snippetService.persist(savedDataFileName);
    }
}