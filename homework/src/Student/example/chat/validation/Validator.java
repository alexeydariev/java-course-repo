package Student.example.chat.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public Validator() {}

    //rules
    public boolean isString(Object value) {
        return value.getClass().getName().equals("java.lang.String");
    }

    public boolean isNotNull(Object value) {
        return value != null;
    }

    public boolean isEmpty(Object value) {
//        if(isString(value)) {
            return ((String) value).isEmpty();
//        }
//        return false;
    }

    public boolean isValidEmail(String value) {
        Pattern pattern = Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"); //factory
        Matcher matcher = pattern.matcher(value); //factory
        return matcher.matches();
    }

    public boolean isValidUserName(String value) {
        Pattern pattern = Pattern.compile("^[a-z][a-z_]{1,15}$");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public boolean isPasswordStrong(String value) {
        String reg = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

}
