package subjects.airplane;

import java.io.Serializable;

public class ExpenseManager implements Serializable {
    private float kerosene;
    private float maintenance;
    private float insurance;
    private float flightCrewCost;
    //private float distance;


    public ExpenseManager(float kerosene, float maintenance, float insurance, float flightCrewCost) {
        this.kerosene = kerosene;
        this.maintenance = maintenance;
        this.insurance = insurance;
        this.flightCrewCost = flightCrewCost;
        //this.distance = distance;
    }

    public float getTotalExpenses(){
        return this.kerosene + this.maintenance + this.insurance + this.flightCrewCost;
    }
//
//    public float getDistance() {
//        return distance;
//    }
//
//    public void setDistance(float distance) {
//        this.distance = distance;
//    }

    public float getKerosene() {
        return kerosene;
    }

    public void setKerosene(float kerosene) {
        this.kerosene = kerosene;
    }

    public float getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(float maintenance) {
        this.maintenance = maintenance;
    }

    public float getInsurance() {
        return insurance;
    }

    public void setInsurance(float insurance) {
        this.insurance = insurance;
    }

    public float getFlightCrewCost() {
        return flightCrewCost;
    }

    public void setFlightCrewCost(float flightCrewCost) {
        this.flightCrewCost = flightCrewCost;
    }

    @Override
    public String toString() {
        return "ExpenseManager{" +
                "kerosene=" + kerosene +
                ", maintenance=" + maintenance +
                ", insurance=" + insurance +
                ", flightCrewCost=" + flightCrewCost +
                '}';
    }
}
