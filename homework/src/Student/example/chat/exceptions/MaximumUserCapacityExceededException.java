package Student.example.chat.exceptions;

public class MaximumUserCapacityExceededException extends Exception {
    public MaximumUserCapacityExceededException(String message) {
        super(message);
    }
}
