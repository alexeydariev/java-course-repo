package student.examples;
import java.io.Serial;
import java.util.UUID;
import java.io.Serializable;


public class Message implements Serializable{ //marker
    @Serial
    private static final long serialVersionUID = 1L; //important huinea s versiamy
    private UUID id;
    private String body;


    public Message (UUID id, String body) {
        this.setBody(body);
        this.setId(id);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", body='" + body + '\'' +
                '}';
    }
}
