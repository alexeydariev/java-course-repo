package student.examples;
public class Laptop implements HasPowerSaving{

    private EqiupmentStates state;

    public Laptop() {
        this.state = EqiupmentStates.OFF;
    }

    @Override
    public void standBy() {
        this.state = EqiupmentStates.STAND_BY;
    }

    @Override
    public void switchOn() {
        this.state = EqiupmentStates.ON;
    }

    @Override
    public void switchOff() {
        this.state = EqiupmentStates.OFF;
    }

    public void dimScreen() {
        this.state = EqiupmentStates.DIMMED;
    }

    @Override
    public boolean isOn() {
        return this.state != EqiupmentStates.OFF;
    }

    public void printStates() {
        for (EqiupmentStates equipmentState : EqiupmentStates.values()) {
            System.out.println(equipmentState);
        }
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "state=" + state +
                ", isOn=" + this.isOn() +
                '}';
    }
}
