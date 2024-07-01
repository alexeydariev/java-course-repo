package Student.homework.exercise.moneywireapp;

public class MoneyWireAppTest {

    static int testCounter = 0;
    static int failCounter = 0;

    public static void main(String[] args) {
        prettyPrint();
        System.out.println("StartTesting");
        testOutOfRange(-100, Bank.money, Bank.JuridicPersonClient.money,
                Bank.PhysicalPersonClient.money);
        testOutOfRange(99, Bank.money, Bank.JuridicPersonClient.money,
                Bank.PhysicalPersonClient.money);
        testOutOfRange(5001, Bank.money, Bank.JuridicPersonClient.money,
                Bank.PhysicalPersonClient.money);
        testInRange500(369, Bank.money, Bank.JuridicPersonClient.money,
                Bank.PhysicalPersonClient.money);
        testInRange500(100, Bank.money, Bank.JuridicPersonClient.money,
                Bank.PhysicalPersonClient.money);
        testInRange500(499, Bank.money, Bank.JuridicPersonClient.money,
                Bank.PhysicalPersonClient.money);
        testInRange5000(500, Bank.money, Bank.JuridicPersonClient.money,
                Bank.PhysicalPersonClient.money);
        testInRange5000(1048, Bank.money, Bank.JuridicPersonClient.money,
                Bank.PhysicalPersonClient.money);
        testInRange5000(5000, Bank.money, Bank.JuridicPersonClient.money,
                Bank.PhysicalPersonClient.money);
        System.out.println("Testing was finished!");
        prettyPrint();
    }

    public static void prettyPrint() {
        System.out.printf("\n========================================================\n" +
                        "Bank account: %d$\n" +
                        "Juridic account: %d$\n" +
                        "Physical account: %d\n" +
                        "Total money: %d $\n" +
                        "Test Executed: %d\n" +
                        "From them Test Failed %d\n" +
                        "========================================================\n",
                Bank.money, Bank.JuridicPersonClient.money, Bank.PhysicalPersonClient.money,
                Bank.money + Bank.JuridicPersonClient.money + Bank.PhysicalPersonClient.money,
                testCounter, failCounter);
    }

    public static void testOutOfRange (int amount, int bank, int juridic, int physical) {
        Bank.transferFromJuridicToPhysical(amount);
        testCounter++;
        if (Bank.money != bank || Bank.JuridicPersonClient.money != juridic
                || Bank.PhysicalPersonClient.money != physical) {
            System.out.println("Test Failed");
            failCounter++;
        } else {
            System.out.println("Test Passed");
        }
    }

    public static void testInRange500 (int amount, int bank, int juridic, int physical) {
        Bank.transferFromJuridicToPhysical(amount);
        testCounter++;
        if (Bank.money != (bank+10) || Bank.JuridicPersonClient.money != (juridic-amount)
                || Bank.PhysicalPersonClient.money != (physical+amount-10)) {
            System.out.println("Test Failed");
            System.out.println(Bank.money);
            System.out.println(bank-10);
            System.out.println(Bank.JuridicPersonClient.money);
            System.out.println(juridic-amount);
            System.out.println(Bank.PhysicalPersonClient.money);
            System.out.println(physical+amount-10);
            failCounter++;
        } else {
            System.out.println("Test Passed");
        }
    }

    public static void testInRange5000 (int amount, int bank, int juridic, int physical) {
        Bank.transferFromJuridicToPhysical(amount);
        testCounter++;
        int bankCommission = 0;
        if (amount % 100 != 0) {
            bankCommission = amount / 100 + 1;
        } else {
            bankCommission = amount / 100;
        }
        if (Bank.money != bank+bankCommission ||
                Bank.JuridicPersonClient.money != (juridic-amount) ||
                Bank.PhysicalPersonClient.money != (physical+amount-bankCommission))
        {
            System.out.println("Test Failed");
            failCounter++;
        } else {
            System.out.println("Test Passed");
        }
    }
}
