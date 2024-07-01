package Student.homework.exercise.cabinet;

public class Main {
    public static void main(String[] args) {
        Cabinet cabinet = new Cabinet();
        System.out.println(cabinet.whatIsOn("topShelf"));
        cabinet.put("topShelf", new Book("1984"));
        System.out.println(cabinet.whatIsOn("topShelf").getName());
    }
}
