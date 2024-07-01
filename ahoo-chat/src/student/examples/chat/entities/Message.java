package student.examples.chat.entities;

import java.util.Date;

public class Message extends Entity {

    //private int id;
    private String body;
    //private User sender;
    //private User receiver;
    //private Date sentAt;
    //private Date receivedAt;
    //private Date seenAt;

    public Message (){
    }

    public Message (int id, String body){
        //super(id);
        this.setId(id);
        this.body = body;
    }

    //TODO:messaging service
    //send message (Message, ->array with message list + add to new pos)
    //message list private
    //no more space

    @Override
    public String toString() {
        return "Message{" +
                "body='" + body + '\'' +
                "id='" + getId() + '\'' +
                '}';
    }
}
