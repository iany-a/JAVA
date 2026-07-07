package subjects.airplane;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Utils {
    public static ArrayList<Airplane> aList = new ArrayList<>();
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
            sortAndAdd(receivedObject);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void sortAndAdd(Airplane a){
        aList.add(a);
        if (aList.size() > 1){
        Collections.sort(aList, new Comparator<Airplane>(){
            public int compare(Airplane a1, Airplane a2){
                return Float.compare(a2.getExpenseManager().getTotalExpenses(), a1.getExpenseManager().getTotalExpenses());
            }
        });

        System.out.println("Sorted list: ");
        System.out.println(aList);
        }
    }



}
