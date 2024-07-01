package student.examples;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import student.examples.devices.HasBattery;
import student.examples.devices.VacuumCleaner;

import static org.testng.Assert.assertEquals;

public class HasBatteryTest {
    private HasBattery hasBattery;

    @BeforeTest (alwaysRun = true)
    void setUp() {
        hasBattery = new VacuumCleaner(1, "sosyara");
        hasBattery.setCharge(50);
        // fails if execution time exceeds 5 seconds
    }

    @Test(groups = {"unit"})
    public void testOvercharge() {
        final int TARGET_CHARGE = 100;
        int chargeBefore = hasBattery.getCharge();
        hasBattery.charge();
        int chargeAfter = hasBattery.getCharge();
        int deltaCharge = chargeAfter - chargeBefore;
        int steps = (TARGET_CHARGE - chargeAfter)/ deltaCharge;
        steps++;

        while (steps-- != 0) {
            hasBattery.charge();
        }
        assertEquals(TARGET_CHARGE, hasBattery.getCharge());
    }

    @Test(groups = {"unit"})
    public void testOverDischarge() {
        final int TARGET_CHARGE = 0;
        int dischargeBefore = hasBattery.getCharge();
        //System.out.println(dischargeBefore);
        hasBattery.discharge();
        int dischargeAfter = hasBattery.getCharge();
        int deltaCharge = dischargeAfter - dischargeBefore;
        int steps = (TARGET_CHARGE - dischargeAfter) / deltaCharge;
        steps++;

        while (steps-- != 0) {
            hasBattery.discharge();
        }
        assertEquals(TARGET_CHARGE, hasBattery.getCharge());
    }
}
