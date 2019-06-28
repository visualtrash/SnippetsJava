import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        Snippet snippet1 = new Snippet("Iam snippet#1", "Iam text of snippet#1");
        Snippet snippet2 = new Snippet("Iam snippet#2", "Iam text of snippet#2");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("snippetun.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(snippet1);
            objectOutputStream.writeObject(snippet2);

            objectOutputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}