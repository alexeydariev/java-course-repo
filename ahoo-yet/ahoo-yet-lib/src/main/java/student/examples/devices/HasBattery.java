package student.examples.devices;

public interface HasBattery {
    public boolean charge();
    public boolean discharge();
    public boolean isCharged();
    public int getCharge();
    public void setCharge(int charge);
}
