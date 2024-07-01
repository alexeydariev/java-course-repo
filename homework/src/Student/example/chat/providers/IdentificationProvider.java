package Student.example.chat.providers;

public class IdentificationProvider {
    public int upperLimit = 1000000;
    public int provide() {
        return (int)(Math.random() * upperLimit + 1);
    }

}
