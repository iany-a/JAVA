package carRental;

public class Car extends Vehicle {
    public Car(String id, String make, String model, Type type, float pricePerDay, float mileage, String city) {
        super(id, make, model, type, pricePerDay, mileage, city);
    }

    @Override
    public boolean isRentable() {
        return super.isRentable();
    }
}
