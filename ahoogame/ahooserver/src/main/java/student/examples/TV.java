package student.examples;

public class TV implements HasPowerSaving {
    private int diagonal;
    private EqiupmentStates state;

    public TV(int diagonal) {
        this.state = EqiupmentStates.OFF;
        this.setDiagonal(diagonal);
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "TV{" +
                "diagonal=" + diagonal +
                ", state=" + this.state +
                ", isOn=" + this.isOn() +
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

    @Override
    public void standBy() {
        this.state = EqiupmentStates.STAND_BY;
    }
}
