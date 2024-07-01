package student.examples.chat.entities;

import java.util.Date;

public class User extends Entity {
    private String username;
    public String password;
    public Date birthdate;
    public char gender;
    private String email;

    public User() {}

    public User(int id, String email, char gender, Date birthdate, String password, String username) {
        super(id);
        this.setEmail(email);
        this.gender = gender;
        this.birthdate = birthdate;
        this.password = password;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public void setEmail(String email) {
        if (email != null) { //TODO: @, . @@ .
            int countAt = 0;
            for(int i=0; i < email.length(); i++) {
                if(email.charAt(i) == '@') {
                    countAt++;
                }
            }
            if (!email.isEmpty()
                    && email.contains("@")
                    && email.contains(".")
                    && !email.startsWith("@")
                    && !email.endsWith("@")
                    && !email.startsWith(".")
                    && !email.endsWith(".")
                    && email.indexOf('@') < email.lastIndexOf('.')
                    && countAt == 1) {
                this.email = email;
                } else {
                    System.out.println("invalid email");
                }

        } else {
            System.out.println("email null");
        }
    }

    public String getEmail() {
            return this.email;
        }

    public String toString () {
        return "User" + " {" + this.username + "}";
    }

/*
    public User (String username, String password, Date birthdate, char gender, String email) {
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.gender = gender;
        this.email = email;
    }
     */


    //public static void main(String[] args) {
    //    User usr = new User(123,"1@com.com", 'm', new Date(), "123", "user");
    //    System.out.println(usr);

   // }
 }

