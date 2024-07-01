package Student.example.chat.entities;

import java.util.Date;
import java.util.UUID;

public class User extends Entity {
    private UUID id;
    private String userName = "";
    private String password = "";
    public Date dob = new Date();
    public Character gender = 'm';
    public String email = "";

    public User() {
        super();
    }

public User(String userName, String password, Date dob, Character gender, String email) {
        super();
        this.userName = userName;
        this.setPassword(password);
        this.dob = dob;
        this.gender = gender;
        this.email = email;
    }

    public void setEmail(String email) {
        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,5}$";
        if (email != null) {
            if (!email.equals("")) {
                if (email.matches(regex)) {
                    email = email.toLowerCase();
                    this.email = email;
                    System.out.println(email + " is a valid email address");
                } else {
                    System.out.println(email + " is not a valid email address");
                }
            } else {
                System.out.println("Email is empty");
            }
        } else {
            System.out.println("Email Null");
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String toString () {
        return "\n\nUser " + this.userName + "\n" +
                this.password + "\n" +
                this.gender +   "\n"
                + this.getId() + "\n"
                + this.email + "\n"
                + this.dob;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
