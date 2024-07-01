package Student.homework.exercise.blenderapp;

public class Apple extends Fruit {
    public Apple(int weight) {
        super(weight);
        this.setUseFull(80);
    }

    public void printVitamins () {
        System.out.println("Merele contin Vitaminele B-complex");
    }
}
