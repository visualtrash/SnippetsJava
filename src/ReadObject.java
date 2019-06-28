import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("snippetun.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Snippet snippet1 = (Snippet) objectInputStream.readObject();
            Snippet snippet2 = (Snippet) objectInputStream.readObject();

            System.out.println(snippet1);
            System.out.println(snippet2);

            objectInputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}