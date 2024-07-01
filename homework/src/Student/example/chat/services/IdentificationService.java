package Student.example.chat.services;
import java.util.Random;
import  java.util.UUID;

public class IdentificationService {
    public IdentificationService () {
    }

    public UUID getId(){
        //factory method
        return UUID.randomUUID();
    }

}
