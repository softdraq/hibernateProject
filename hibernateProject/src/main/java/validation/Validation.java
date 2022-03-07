package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean username(String username) {
        Pattern pattern = Pattern.compile("[a-z][A-Z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(username);
        boolean matchFound = matcher.find();
        if (matchFound) {
            if (username.length() >= 3 && username.length() <= 20) {
                return true;
            }
        }
        return false;
    }

    public static boolean email(String email) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();
        return matchFound;
    }

    public static boolean password(String password) {
        Pattern pattern = Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.find();
        if (matchFound) {
            if (password.length() >= 6 && password.length() <= 10) {
                return true;
            }
        }
        return false;
    }

}
