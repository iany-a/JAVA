import java.io.Serializable;

public abstract class Vehicle implements Serializable {
    String id;
    String make;
    String model;
    String type;
    Float price;
    Float mileage;
    String city;

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getMileage() {
        return mileage;
    }

    public void setMileage(Float mileage) {
        this.mileage = mileage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Vehicle(String id, String make, String model, String type, Float price, Float mileage, String city) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.type = type;
        this.price = price;
        this.mileage = mileage;
        this.city = city;
    }
}
