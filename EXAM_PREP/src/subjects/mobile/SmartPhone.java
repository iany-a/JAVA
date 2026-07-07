package subjects.mobile;

public class SmartPhone extends Phone{
    private int batteryDuration;

    @Override
    public String infoDevice(){
        return String.valueOf(this.batteryDuration);
    }

    public int getBatteryDuration() {
        if (this.batteryDuration <=0) throw new UnsupportedOperationException("Invalid input.");
        return batteryDuration;
    }

    public void setBatteryDuration(int batteryDuration) {
        this.batteryDuration = batteryDuration;
    }




}
