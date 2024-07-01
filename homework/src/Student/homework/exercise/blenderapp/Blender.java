package Student.homework.exercise.blenderapp;

public class Blender {
    public Juice blend (Fruit fruit) {
        Juice juice = new Juice(fruit.getWeight() * fruit.getUseFull()/100);
        return juice;
    }
}
