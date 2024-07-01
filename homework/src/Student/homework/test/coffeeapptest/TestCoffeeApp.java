package Student.homework.test.coffeeapptest;

import Student.homework.exercise.coffeeapp.Container;

public class TestCoffeeApp {
    public static void main(String[] args) {
        Container cup = new Container();
        cup.setVolume(100);
        System.out.println(cup.toString() + cup.getVolume() + " ml");
        cup.setVolume(50);
        System.out.println(cup.toString() + cup.getVolume() + " ml");
        cup.setVolume(200);
        System.out.println(cup.toString() + cup.getVolume() + " ml");
        cup.setVolume(0);
        System.out.println(cup.toString() + cup.getVolume() + " ml");
        cup.setVolume(137);
        System.out.println(cup.toString() + cup.getVolume() + " ml");
        cup.setVolume(20);
        System.out.println(cup.toString() + cup.getVolume() + " ml");
    }
}
