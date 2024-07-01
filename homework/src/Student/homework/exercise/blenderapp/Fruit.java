package Student.homework.exercise.blenderapp;

abstract public class Fruit {
    private int weight;
    private int useFull;

    public Fruit() {}

    public Fruit(int weight) {
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }

    public int getUseFull() {
        return useFull;
    }

    public void setUseFull(int useFull) {
        this.useFull = useFull;
    }

    abstract public void printVitamins();

}
