package subjects.mobile;

import java.io.Serializable;
import java.util.Objects;

public class Phone implements ElectronicDevices, Cloneable, Serializable {

    private float weight;
    private double diagonal;
    private String producer;

    public Phone() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.weight, this.diagonal, this.producer);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() !=obj.getClass()) return false;

        Phone other = (Phone) obj;
        return Float.compare(this.weight, other.weight) == 0 && Double.compare(this.diagonal, other.diagonal)==0 && Objects.equals(this.producer, other.producer);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if (weight <= 0) throw new UnsupportedOperationException("Invalid input.");
        this.weight = weight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        if (diagonal <= 0) throw new UnsupportedOperationException("Invalid input.");
        this.diagonal = diagonal;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        if (producer == null || producer.length()<=1) throw new UnsupportedOperationException("Invalid input.");
        this.producer = producer;
    }

    @Override
    public String infoDevice() {
        return this.producer;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "weight=" + weight +
                ", diagonal=" + diagonal +
                ", producer='" + producer + '\'' +
                '}';
    }
}
