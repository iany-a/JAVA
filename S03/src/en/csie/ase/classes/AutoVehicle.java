package en.csie.ase.classes;

public class AutoVehicle extends Vehicle {



    public AutoVehicle(String brand, int capacity, String model, int[] weightPerPassenger) {
        super(brand, capacity, model, weightPerPassenger);
        //super is a shortcut on calling ALL parent classes on the hierarchy (in order)
        //super is mandatory to not manually write all the links from the hierarchy


    }
}
