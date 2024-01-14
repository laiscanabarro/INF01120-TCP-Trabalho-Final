package user;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authentication {

    public static boolean isValidEmail(String email) {

        // Regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Create pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Create matcher
        Matcher matcher = pattern.matcher(email);

        // Check if it matches the pattern
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }
}