package student.examples;

public class App {
    public static void main(String[] args) {
        Fridge fridge = new Fridge(50);
        TV tv = new TV(55);
        tv.switchOn();
        tv.standBy();
        fridge.switchOn();
        System.out.println(tv);
        System.out.println(fridge);

        Laptop laptop = new Laptop();
        laptop.switchOn();
        laptop.dimScreen();
        laptop.standBy();
        System.out.println(laptop);
        //laptop.printStates();
    }
}
