package student.examples.chat.services;

import student.examples.chat.entities.Message;

public class MsgService {
    private  Message[] messagesList;

    public MsgService() {
        this.setMessagesList(5);
    }

    public MsgService(int msgNum) {
        this.setMessagesList(msgNum);
    }

    public Message[] getMessagesList(){
        return this.messagesList;
    }

    public void setMessagesList(int len) {
        this.messagesList = new Message[len];
    }

    public void sent(Message msg) {
        int lastMsgIdx = this.messagesList.length-1;
        for (int msgPos = 0; msgPos <=lastMsgIdx; msgPos++) {
            if (messagesList[msgPos] == null) {
                messagesList[msgPos] = msg;
                break;
            } else if (msgPos == lastMsgIdx && messagesList[msgPos] != null) {
                System.err.println("No more space");
            }
        }
    }

    //public void checkFreeSpace() {
    //    if (this.messagesList)
    //}

}
