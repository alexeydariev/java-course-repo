package Student.homework.exercise.cabinet;

public class Tablet extends Thing {
    private String name;

    public Tablet() {}

    public Tablet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "name='" + name + '\'' +
                '}';
    }
}
