import student.examples.chat.entities.Entity;
import student.examples.chat.entities.Message;
import student.examples.chat.entities.User;
import student.examples.chat.services.AuthService;
import student.examples.chat.services.MsgService;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


        AuthService authService = new AuthService();
        //User user1 = new User(123, "ad@example.com", 'm', new Date(), "pwd123", "ad123" );
        //User user2 = new User(124, "ad@example.com", 'm', new Date(), "pwd123", "ad123" );;
        //authService.signUp(new User(123, "ad@example.com", 'm', new Date(), "pwd123", "ad123" ));
        //authService.signUp(new User(124, "ad1@example.com", 'm', new Date(), "pwd123", "ad124" ));
        //authService.signUp(new User(125, "ad2@example.com", 'm', new Date(), "pwd123", "ad125" ));
        //authService.signUp(new User(126, "ad3@example.com", 'm', new Date(), "pwd123", "ad125" ));

        int i = 0;
        while (i < 10 ) {
            authService.signUp(new User(123+i , "ad@example.com", 'm', new Date(), "pwd123", "ad"+i));
            i++;
        }


    }
}