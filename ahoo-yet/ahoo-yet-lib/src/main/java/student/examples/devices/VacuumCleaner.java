package student.examples.devices;

import java.io.Serializable;

import static student.examples.devices.PowerState.*;

public class VacuumCleaner extends NetworkDevice implements HasPowerStates, HasBattery, Serializable {
    private final int MIN_CHARGE = 10;
    private PowerState powerState;
    private int charge;


    public VacuumCleaner () {
        this.init();
    }

    public VacuumCleaner(int id, String name) {
        super(id, name);
        this.init();
    }

    private void init() {
        this.setCharge(0);
        this.switchOff();
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        if (charge >= 0 && charge <= 100) {
            this.charge = charge;
        }
    }

    @Override
    public boolean switchOn() {
        powerState = ON;
        return true;
    }

    @Override
    public boolean switchOff() {
        powerState = OFF;
        return true;
    }

    @Override
    public boolean isOn() {
        return powerState != OFF;
    }

    @Override
    public boolean charge() {
        //if (this.getCharge() < 100) {
            setCharge(this.getCharge() + 5);
        //}
        return false;
    }

    @Override
    public boolean discharge() {
        //if (this.getCharge() > 0) {
        setCharge(this.getCharge() - 5);
        //}
        return false;
    }

    @Override
    public boolean isCharged() {
        return this.getCharge() >= MIN_CHARGE;
    }

    @Override
    public String toString() {
        return super.toString() + "\n |\n +-VacuumCleaner{" +
                "powerState=" + powerState +
                ", charge=" + charge +
                '}';
    }
}
