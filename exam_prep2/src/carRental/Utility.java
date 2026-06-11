package carRental;

public class Utility extends Vehicle {
    private float maxPayload;


    public Utility(String id, String make, String model, float pricePerDay, float mileage, String city, float maxPayLoad) {
        super(id, make, model, null, pricePerDay, mileage, city);
        this.maxPayload = maxPayLoad;
        this.setType(Type.TRUCK);
    }

    public float getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(float maxPayload) {
        this.maxPayload = maxPayload;
    }



    @Override
    public boolean isRentable() {
        return super.isRentable();
    }
}
