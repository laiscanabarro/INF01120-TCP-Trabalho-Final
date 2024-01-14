package user;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authentication {

    private static final int PASSWORD_LENGTH = 6;
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static boolean isValidEmail(String email) {

        // Create pattern
        Pattern pattern = Pattern.compile(EMAIL_REGEX);

        // Create matcher
        Matcher matcher = pattern.matcher(email);

        // Check if it matches the pattern
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= PASSWORD_LENGTH;
    }

}