package Student.homework.kitchen.cup;

import Student.homework.kitchen.world.Liquid;

public class Application {
    public static void main(String[] args) {
        //Cup cupA = new Cup("Milk", 300);
        //Cup cupB = new Cup(new Liquid("HZ", 500, ));

        //cupA.setLiquidVolume(cupA.getLiquidVolume()-50);
        //cupB.setLiquidVolume(cupB.getLiquidVolume()+50);

        //System.out.println(cupA);
        //System.out.println(cupB);

        /*
        SmallCup smallCup = new SmallCup("Water", 200);

        System.out.println(smallCup.getLiquidVolume() + " " + smallCup.getLiquidName());

        BigCup bigCup = new BigCup("Water", 200);

        bigCup.setLiquidVolume(bigCup.getLiquidVolume() + cupB.getLiquidVolume());
        System.out.println(bigCup.getLiquidVolume());

        Liquid irishCoffee = new Liquid("Irish coffee", 75, 36);
        Liquid beer = new Liquid("Beer", 500, 7);
        Liquid cumPot = new Liquid("cumPot", 250, 69);


        System.out.println(irishCoffee.getName() + " " + irishCoffee.isWarm());
        System.out.println(beer.getName() + " " + beer.isCold());
        System.out.println(cumPot.getName() + " " + cumPot.isHot());
        */

        Cup standartCup = new Cup(new Liquid("Water", 500, 10));
        standartCup.setLiquidVolume(standartCup.getLiquid().getVolume() + 200);
        System.out.println(standartCup.getLiquid().getName() + " " + standartCup.getLiquid().getVolume() + " " + standartCup.getLiquid().getTemp());
    }
}
