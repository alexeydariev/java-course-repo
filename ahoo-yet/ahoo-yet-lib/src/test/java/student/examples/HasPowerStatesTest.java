package student.examples;

import junit.framework.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;
import student.examples.devices.HasPowerStates;
import student.examples.devices.VacuumCleaner;

public class HasPowerStatesTest {
    private HasPowerStates hasPowerStates;

    @BeforeTest (alwaysRun = true)
    void setUp() {
        hasPowerStates = new VacuumCleaner();
        // fails if execution time exceeds 5 seconds
    }

    @Test(groups = {"unit"})
    public void testIsOn() {
        Assert.assertFalse(hasPowerStates.isOn());
        hasPowerStates.switchOn();
        Assert.assertTrue(hasPowerStates.isOn());
    }

    @Test(groups = {"unit"})
    public void testSwitchOn() {
        hasPowerStates.switchOn();
        Assert.assertTrue(hasPowerStates.isOn());
    }

    @Test(groups = {"unit"})
    public void testSwitchoff() {
        hasPowerStates.switchOn();
        hasPowerStates.switchOff();
        Assert.assertFalse(hasPowerStates.isOn());
    }
}
