package Student.example.chat.services;

import Student.example.chat.entities.Message;

public class MessagingService {
    private Message[] messages = new Message[5];
    private int counter = 0;

    public MessagingService() {}

    public Message[] getMessages() {
        return messages;
    }

    public void sent(Message message) {
        if (counter < messages.length) {
            messages[counter] = message;
            counter++;
            System.out.println("Message sent: " + message);
        }
        else {
            System.out.println("Message stack is oweroaded! " + message);
        }
    }


}
