package Student.example.chat.entities;

import Student.example.chat.services.IdentificationService;

import java.util.UUID;

public abstract class Entity {
    private UUID id;
    private IdentificationService identificationService = new IdentificationService();


    public Entity() {
        this.setId();
    }

    //public Entity(UUID id) {
    //    setId();
    //}

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = identificationService.getId();
    }
}
