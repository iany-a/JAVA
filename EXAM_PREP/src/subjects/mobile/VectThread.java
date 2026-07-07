package subjects.mobile;

import java.util.List;

public class VectThread implements Runnable{

    private List<ElectronicDevices> phonesList;
    private double avgWeight = 0;

    public VectThread(List<ElectronicDevices> phonesList, double avgWeight) {
        this.phonesList = Utils.readBinaryPhones(Utils.directory + "output.ser");
        this.avgWeight = avgWeight;
    }

    public List<ElectronicDevices> getPhonesList() {
        return phonesList;
    }

    public void setPhonesList(List<ElectronicDevices> phonesList) {
        this.phonesList = phonesList;
    }

    public double getAvgWeight() {
        return avgWeight;
    }

    public void setAvgWeight(double avgWeight) {
        this.avgWeight = avgWeight;
    }


    @Override
    public void run() {
        double sum = 0;
        int size = 0;
        for (ElectronicDevices p : phonesList){
            sum += ((Phone) p).getWeight();
            size++;
        }
        this.avgWeight = sum/size;
    }
}
