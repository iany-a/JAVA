package subjects.mobile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static List<ElectronicDevices> devicesList;
    public static String directory = "src\\subjects\\mobile\\";

    public static List<ElectronicDevices> createPhone(int n) throws Exception{
        devicesList = new ArrayList<>();
        for(int i=0; i<n; i++){
            Phone p = new Phone();
            devicesList.add(p);
        }
        return devicesList;
    }

    public static List<ElectronicDevices> readPhones(String file){
        List<ElectronicDevices> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine())!=null){
                float weight = Float.parseFloat(line.trim());
                double diagonal = Double.parseDouble(reader.readLine().trim());
                String producer = reader.readLine().trim();

                Phone p = new Phone();
                p.setWeight(weight);
                p.setDiagonal(diagonal);
                p.setProducer(producer);

                list.add(p);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void writeBinaryPhones(String file, List<ElectronicDevices> listP){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for(ElectronicDevices a : listP){
                objectOutputStream.writeObject(a);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<ElectronicDevices> readBinaryPhones(String file){
        List<ElectronicDevices> list = new ArrayList<>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            while(true) {
                Phone p = (Phone) objectInputStream.readObject();
                list.add(p);
            }
        } catch(EOFException e){
        }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


}
