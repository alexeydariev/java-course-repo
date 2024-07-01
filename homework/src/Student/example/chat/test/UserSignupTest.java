package Student.example.chat.test;

import Student.example.chat.entities.User;
import Student.example.chat.services.AuthService;
import com.github.javafaker.Faker;

import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

public class UserSignupTest {

    private User[] users;
    private final int MAX_USERS = 100;
    private AuthService authService;
    private Faker faker;
    public int counterSuccess = 0;
    public int counterFailure = 0;


    public int getMAX_USERS() {
        return MAX_USERS;
    }
    public User[] getUsers() {
        return users;
    }

    public UserSignupTest () {
        users = new User[MAX_USERS];
    }

    public void before () {

        authService = new AuthService();

        int id = 1;
        char[] genders = {'m', 'f'};
        users = new User[MAX_USERS];
        faker = new Faker(Locale.FRANCE);

        for (int i = 0; i < MAX_USERS; i++) {
            users[i] = new User(
                    faker.name().username(),
                    faker.internet().password(),
                    faker.date().between(new Date(80, Calendar.JANUARY, 1), new Date(123, Calendar.JANUARY, 1)),
                    genders[new Random().nextInt(genders.length)],
                    faker.internet().emailAddress());
            }
        }
        //setup

    public void sameUserSetUp () {
        int id = 1;
        char[] genders = {'m', 'f'};
        users = new User[MAX_USERS];
        for (int i = 0; i < MAX_USERS; i++) {
            users[i] = new User( "sasi",
                    "123", new Date(), 'm', "jh@e.h");
        }

    }

    // TODO HW - add logic to register 100 same users
    // todo condition - success conditions
    public void test() {
            for (int i = 0; i < users.length; i++) {
                try {
                    authService.signUp(users[i]);
                    counterSuccess++;
                } catch (Exception e) {
                    //e.printStackTrace();
                    counterFailure++;
                }
        }
    } // test
    public void after() {} //teardown
}
