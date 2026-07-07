package carRental;

public class Bus extends Vehicle {
    private String accommodation;

    public Bus(String id, String make, String model, float pricePerDay, float mileage, String city, String accommodation) {
        super(id, make, model, null, pricePerDay, mileage, city);
        this.accommodation = accommodation;
        this.setType(Type.RV);
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    @Override
    public boolean isRentable() {
        return super.isRentable();
    }
}
