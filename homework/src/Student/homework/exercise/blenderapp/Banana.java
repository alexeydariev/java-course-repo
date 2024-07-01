package Student.homework.exercise.blenderapp;

public class Banana extends Fruit{
    public Banana (int weight) {
        super(weight);
        this.setUseFull(70);
    }

    public void printVitamins () {
        System.out.println("Merele contin Vitaminele B-complex");
    }
}
