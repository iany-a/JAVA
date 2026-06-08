package subjects.airplane;

import java.io.*;

public class Utils {
    public static String filePathClient = "src\\subjects\\airplane\\client\\";
    public static String filePathServer = "src\\subjects\\airplane\\server\\";
    public static void serialize(Airplane a, String path){
        try {
            FileOutputStream f1 = new FileOutputStream(path);
            ObjectOutputStream o1 = new ObjectOutputStream(f1);
            o1.writeObject(a);
            o1.close();
            f1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deserialize(String path){
        try {
            FileInputStream f1 = new FileInputStream(path);
            ObjectInputStream objIn = new ObjectInputStream(f1);

            Airplane receivedObject = (Airplane) objIn.readObject();
            System.out.println("Object deserialized. Printing details: ");
            System.out.println(receivedObject.toString());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
