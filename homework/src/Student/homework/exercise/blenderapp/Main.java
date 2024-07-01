package Student.homework.exercise.blenderapp;

public class Main {
    public static void main(String[] args) {
        Fruit apple = new Apple(50);
        Fruit banana = new Banana(180);
        Fruit orange = new Orange(500);

        Blender portableBlender = new Blender();
        Juice appleJuice = portableBlender.blend(apple);
        Juice bananaJuice = portableBlender.blend(banana);
        Juice orangeJuice = portableBlender.blend(orange);
        System.out.println("Din "+apple.getWeight() +"g de mere am obtinut: "
                +appleJuice.getVolume() +"ml de suc ");
        apple.printVitamins();
        System.out.println("Din "+banana.getWeight() +"g de banane am obtinut: "
                +bananaJuice.getVolume() +"ml de suc ");
        banana.printVitamins();
        System.out.println("Din "+orange.getWeight() +"g de portocale am obtinut: "
                +orangeJuice.getVolume() +"ml de suc ");
        orange.printVitamins();
    }

}
