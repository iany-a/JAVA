package carRental;

public class Military extends Vehicle {
    public Military(String id, String make, String model, float pricePerDay, float mileage, String city) {
        super(id, make, model, null, pricePerDay, mileage, city);
        this.setType(Type.MILITARY);
    }

    @Override
    public boolean isRentable() {
        return false;
    }
}
