package Student.example.chat.services;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Student.example.chat.entities.Message;
import Student.example.chat.entities.User;
import Student.example.chat.exceptions.MaximumUserCapacityExceededException;
import Student.example.chat.exceptions.UserAlreadyExistsException;

public class AuthService {

    final int MAX_USERS = 1000;
    private List<User> users; //class load

    public AuthService() {
        this.setUsers(new ArrayList<>());
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    //TODO  HW - check uniq usr throw exc
    public void signUp(User user)  {
        try {
            checkExistingUser(user);
            checkCapacity();
        } catch (UserAlreadyExistsException e) {
            throw new RuntimeException(e);
        } catch (MaximumUserCapacityExceededException e) {
            throw new RuntimeException(e);
        }
        this.users.add(user);
        user.setPassword(encryptUserPassword(user));
    }

    private void checkExistingUser(User newUser) throws UserAlreadyExistsException {
        for (User user : this.users) {
            if (user == null) {
                continue;
            } else if (user.getUserName().equals(newUser.getUserName())) {
                throw new UserAlreadyExistsException("User already exists");
                }
            }
    }

    public void checkCapacity () throws MaximumUserCapacityExceededException {
        if (this.users.size() > MAX_USERS) throw new MaximumUserCapacityExceededException("Max Capacity exceeded");
    }

    public User authentificate (String username, String password) {
        User user = null;
        String pwdHash = users.get(srchUsrByUname(username)).getId().toString().substring(0,8) + getHash256(password);
        if ((users.get(srchUsrByUname(username)).getPassword()).equals(pwdHash)) {
            user = users.get(srchUsrByUname(username));
        }
        return user;
    }

    public String getHash256(String value) {
        StringBuilder hex = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = digest.digest(value.getBytes("UTF-8"));
            for (byte i : hashedPassword) {
                hex.append(String.format("%02X", i));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return hex.toString();
    }

    public void signIn() {}
    public void signOut() {}
    //TODO HW - refactor - reduce arr
    public void dropOut(User user) {
        this.users.remove(user);
    }
    //helpers
    public int srchUsr(User user) {
        return this.users.indexOf(user);
    }

    public int srchUsrByUname(String username) {
        int usrIdx = -1;
        for (User user: this.users) {
            if (user.getUserName().equals(username)) {
                usrIdx = this.users.indexOf(user);
            }
        }
        return usrIdx;
    }

    ////security

    public String encryptUserPassword(User user) {
        StringBuilder uuidSalt = new StringBuilder(user.getId().toString().substring(0,8));
        return uuidSalt + getHash256(user.getPassword());
    }
}
