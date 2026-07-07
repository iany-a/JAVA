package carRental;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static String directory = "src\\carRental\\";

    public static List<Vehicle> readInListTxt(String fileName){
        List<Vehicle> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(directory + "input.txt"))) {
            String line;
            while((line = reader.readLine()) != null){
                String[] individual = line.split(";");
                String id = individual[0];
                String make = individual[1];
                String model = individual[2];
                Type type = Type.valueOf(individual[3]);
                float pricePerDay = Float.parseFloat(individual[4]);
                float mileage = Float.parseFloat(individual[5]);
                String city = individual[6];

                Vehicle c = new Car(id, make, model, type, pricePerDay, mileage, city);
                list.add(c);
                System.out.println("Object read from file and returned as list.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void writeListTxt(String file, List<Vehicle> list){
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))){
            for(Vehicle c : list){
                pw.println(c.getId() + ";" + c.getMake() + ";" + c.getModel() + ";"
                        + c.getType() + ";" + c.getPricePerDay() + ";" + c.getMileage() + ";"
                        + c.getCity() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public static void serializeToStream(OutputStream outputStream, List<Vehicle> list){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
            for(Vehicle c : list){
                objectOutputStream.writeObject((Car)c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
   }

   public static List<Vehicle> deserializeFromStream(InputStream inputStream){
        List<Vehicle> list = new ArrayList<>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){
            while(true){
                list.add((Car) objectInputStream.readObject());
            }
        } catch (EOFException e){}
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
   }


}
