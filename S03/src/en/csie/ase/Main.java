package en.csie.ase;

import en.csie.ase.classes.AutoVehicle;
import en.csie.ase.classes.Vehicle;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] array1 = new int[]{50, 12, 37, 16, 20};
        AutoVehicle autoVehicle1 = new AutoVehicle("BMW", 4, "M5", array1);
        System.out.println(autoVehicle1.getBrand());
        autoVehicle1.move(30);

        AutoVehicle autoVehicle2 = (AutoVehicle) autoVehicle1.clone();
        Object o;
    }
}