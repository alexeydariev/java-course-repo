package Student.homework.exercise.cabinet;

public class Cabinet {
    private Thing topShelf;
    private Thing middleShelf;
    private Thing bottomShelf;

    public Cabinet() {}



    Thing whatIsOn(String shelfName) {
        switch (shelfName) {
            case "topShelf":
                return topShelf;
            case "middleShelf":
                return middleShelf;
            case "bottomShelf":
                return bottomShelf;
            default:
                System.err.println("Invalid shelf name");
                return null;
        }
    }

    void put(String shelfName, Thing thing) {
        switch (shelfName) {
            case "topShelf":
                topShelf = thing;
                break;
            case "middleShelf":
                middleShelf = thing;
                break;
            case "bottomShelf":
                bottomShelf = thing;
                break;
            default:
                System.err.println("Invalid shelf name");
        }
    }

    Thing take(String shelfName) {
        Thing buffer = null;
        switch (shelfName) {
            case "topShelf":
                buffer = topShelf;
                topShelf = null;
                return buffer;
            case "middleShelf":
                buffer = middleShelf;
                middleShelf = null;
                return buffer;
            case "bottomShelf":
                buffer = bottomShelf;
                bottomShelf = null;
                return buffer;
            default:
                System.err.println("Invalid shelf name");
                return null;
        }
    }
}
