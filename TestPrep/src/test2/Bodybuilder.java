package test2;

import java.util.Date;

public class Bodybuilder implements Notifyable{
    String name;
    int weight;
    int liftedWeight;
    int repetitions;

    public Bodybuilder(String name, int weight, int liftedWeight, int repetitions) {
        this.name = name;
        this.weight = weight;
        this.liftedWeight = liftedWeight;
        this.repetitions = repetitions;
    }

    @Override
    public String toString() {
        return "BodyBuilder{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", liftedWeight=" + liftedWeight +
                ", repetitions=" + repetitions +
                '}';
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLiftedWeight() {
        return liftedWeight;
    }

    public void setLiftedWeight(int liftedWeight) {
        this.liftedWeight = liftedWeight;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    @Override
    public void notify(long timestamp) {
        Date date = new Date(timestamp);
        System.out.println("[" + date + "]" + " New record for existing candidate!");
    }
}
