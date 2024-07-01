import Student.example.chat.test.UserSignupTest;

public class MainTest {
    public static void main(String[] args) {
        UserSignupTest userSignupTest = new UserSignupTest();
        userSignupTest.before();
        //for (int i = 0; i < userSignupTest.getUsers().length; i++){
        //    System.out.println(userSignupTest.getUsers()[i]);
        //}
        userSignupTest.test();
        //System.out.println(userSignupTest.counterSuccess);
        //System.out.println(userSignupTest.counterFailure);
        userSignupTest.sameUserSetUp();
        userSignupTest.test();
        System.out.println(userSignupTest.counterSuccess);
        System.out.println(userSignupTest.counterFailure);

    }
}
