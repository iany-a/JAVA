import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static String workingFile = "src\\input.txt";

    public static List<Vehicle> readFromFile(String inputfile){
        List<Vehicle> list = new ArrayList<>();
        int counter = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputfile))){
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] currentLine = line.split(";");
                String id = currentLine[0];
                String make = currentLine[1];
                String model = currentLine[2];
                String type = currentLine[3];
                Float price = Float.valueOf(currentLine[4]);
                Float mileage = Float.valueOf(currentLine[5]);
                String city = currentLine[6];

                Vehicle v = new Car(id, make, model, type, price, mileage, city);

                list.add(v);
                counter++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Read " + counter + " object(s) from file, added them to collection");
        return list;
    }

    public static void serializeToStream(OutputStream outputStream, List<Vehicle> list){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
            int i = 0;
            for (Vehicle c : list){
                objectOutputStream.writeObject((Car)c);
                i++;
            }
            System.out.println("Sent " + i + " object(s) as data to output stream");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Vehicle> deserializeFromStream(InputStream inputStream) {
        List<Vehicle> list = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            while (true) {
                list.add((Car) objectInputStream.readObject());
            }
        } catch (EOFException e){}
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }



}
