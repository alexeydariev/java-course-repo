package Student.homework.exercise.moneywireapp;

public class MoneyWireApp {
    public static void main(String[] args) {
        System.out.println("Bank account: "+Bank.money+"$");
        System.out.println("Juridic Person account: "+Bank.JuridicPersonClient.money+"$");
        System.out.println("Physical Person account: "+Bank.PhysicalPersonClient.money+"$");
        Bank.transferFromJuridicToPhysical(5000);
        Bank.transferFromJuridicToPhysical(5000);
        Bank.transferFromJuridicToPhysical(5000);
        Bank.transferFromJuridicToPhysical(5000);
        Bank.transferFromJuridicToPhysical(5000);
        Bank.transferFromJuridicToPhysical(5000);
        Bank.transferFromJuridicToPhysical(5000);
        Bank.transferFromJuridicToPhysical(4000);
        Bank.transferFromJuridicToPhysical(1050);
        System.out.println("Bank account: "+Bank.money+"$");
        System.out.println("Juridic Person account: "+Bank.JuridicPersonClient.money+"$");
        System.out.println("Physical Person account: "+Bank.PhysicalPersonClient.money+"$");
    }
}

// secondary class
class Bank {

    static int money = 0;

    static class PhysicalPersonClient {
        static int money = 100;

    }
    static class JuridicPersonClient {
        static int money = 1000000;
    }

    static void transferFromJuridicToPhysical(int amount){
        if (amount <100 || amount > 5000){
            System.out.println("Amount must be between 100 and 5000");
        } else if (amount > JuridicPersonClient.money){
            System.out.println("Amount is more than Juridic Person have in account");
        } else if (amount < 500){
            JuridicPersonClient.money -= amount;
            System.out.println("Successfully withdraw "+amount+"$ from Juridic Person");
            PhysicalPersonClient.money += (amount-10);
            System.out.println("Successfully transfer "+(amount-10)+"$ to Physical Person");
            money += 10;
            System.out.println("Successfully transfer 10$ to Bank account");
        } else {
            int bankCommission = 0;
            if (amount % 100 != 0) {
                bankCommission = amount / 100 + 1;
            } else {
                bankCommission = amount / 100;
            }
            JuridicPersonClient.money -= amount;
            System.out.println("Successfully withdraw "+amount+"$ from Juridic Person");
            PhysicalPersonClient.money += (amount-bankCommission);
            System.out.println("Successfully transfer "+(amount-bankCommission)+
                    "$ to Physical Person");
            money += bankCommission;
            System.out.println("Successfully transfer "+bankCommission+"$ to Bank account");
        }
    }

}