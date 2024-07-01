package student.examples;

public class Fridge implements Switchable {
    private int volume;
    private EqiupmentStates state;

    public Fridge(int volume) {
        this.state = EqiupmentStates.OFF;
        this.setVolume(volume);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "volume=" + volume +
                ", state=" + this.state +
                ", isOn=" + isOn() +
                '}';
    }

    @Override
    public void switchOn() {
        this.state = EqiupmentStates.ON;
    }

    @Override
    public void switchOff() {
        this.state = EqiupmentStates.OFF;
    }

    @Override
    public boolean isOn() {
        return this.state != EqiupmentStates.OFF;
    }

}
