public class Authentication {

    public static final int MAX_LOGIN_ATTEMPTS = 3;
    private int failedAttempts = 0;

    public boolean authenticate(User user, String inputEmail, String inputPassword) {
        if (user.getEmail().equals(inputEmail) && user.getPassword().equals(inputPassword)) {
            System.out.println("Success!");
            failedAttempts = 0; 
            return true;
        } else {
            failedAttempts++;
            if(failedAttempts >= MAX_LOGIN_ATTEMPTS) {
                System.out.println("Account blocked due to too many failed login attempts.");
            } else {
                System.out.println("Login failed. Check your email and password and try again. After 3 attempts your account will be blocked.");
            }
            return false;
        }
    }
}