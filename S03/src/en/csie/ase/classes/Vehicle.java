package en.csie.ase.classes;

import en.csie.ase.interfaces.Movable;

public abstract class Vehicle implements Movable, Cloneable {

    String brand;
    int capacity;
    String model;
    int[] weightPerPassenger;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int[] getWeightPerPassenger() {
        return weightPerPassenger;
    }

    public void setWeightPerPassenger(int[] weightPerPassenger) {
        this.weightPerPassenger = new int[weightPerPassenger.length];
        for(int i=0; i<weightPerPassenger.length;i++){
            this.weightPerPassenger[i] = weightPerPassenger[i];
        }
    }

    public Vehicle(String brand, int capacity, String model, int[] weightPerPassenger) {
        this.brand = brand;
        this.capacity = capacity;
        this.model = model;
        this.weightPerPassenger = new int[weightPerPassenger.length];
        for(int i=0; i<weightPerPassenger.length;i++){
            this.weightPerPassenger[i] = weightPerPassenger[i];
        }
    }

    @Override
    public void move(int km) {
        System.out.println("Moving distance: " + km);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        //return super.clone(); //shallow copy
        //we are not calling new in the clone method


        //correct way to implement the clone method
        Vehicle v  = (Vehicle) super.clone();
        v.brand = this.brand;
        v.model = this.model;
        v.capacity = this.capacity;
        v.weightPerPassenger = new int[this.weightPerPassenger.length];
        for (int i=0; i<this.weightPerPassenger.length; i++){
            v.weightPerPassenger[i] = this.weightPerPassenger[i];
        }
        return v;
    }
}

