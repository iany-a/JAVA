package carRental;

import java.io.Serializable;

public abstract class Vehicle implements Rentable, Serializable {

    private String id;
    private String make;
    private String model;
    private Type type;
    private float pricePerDay;
    private float mileage;
    private String city;

    public Vehicle(String id, String make, String model, Type type, float pricePerDay, float mileage, String city) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.type = type;
        this.pricePerDay = pricePerDay;
        this.mileage = mileage;
        this.city = city;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", type=" + type +
                ", pricePerDay=" + pricePerDay +
                ", mileage=" + mileage +
                ", city='" + city + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean isRentable() {
        return true;
    }
}
