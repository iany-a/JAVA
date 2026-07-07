package subjects.mobile;

import java.util.ArrayList;
import java.util.List;

public class ProgMainPlayGround {
    public static void main(String[] args) {
        Phone e1 = new Phone();
        e1.setProducer("Nokia");
        e1.setDiagonal(6.5);
        e1.setWeight(300);

        List<ElectronicDevices> list = new ArrayList<>();
        try {
            list = Utils.createPhone(5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String workingDirectory = "src\\subjects\\mobile\\";

        System.out.println(list);
        list = Utils.readPhones(workingDirectory + "input.txt");
        System.out.println(list);
        //List<ElectronicDevices> listBinary = new ArrayList<>();
        List<ElectronicDevices> listBinaryFromFile = new ArrayList<>();

        Utils.writeBinaryPhones(workingDirectory + "output.ser", list);
        List<ElectronicDevices> listBinary = new ArrayList<>();
        listBinary = Utils.readBinaryPhones(workingDirectory + "output.ser");
        System.out.println(listBinary);


    }
}
