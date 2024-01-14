package content;

import org.junit.jupiter.api.*;
import user.Authentication;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticationTest {
    String email1;
    String username;
    String password1;
    String password2;
    @BeforeAll
    public static void start() {
        System.out.println("Initiating Authentication tests");
    }

    @BeforeEach
    public void init() {
        email1 = "valid@email.com";
        username = "username";
        password1 = "GoodPassword";
        password2 = "bad";
    }

    @Test
    @DisplayName("test email validation")
    void emailValidation() {
        assertTrue(Authentication.isValidEmail(email1));
        assertFalse(Authentication.isValidEmail(username));
    }

    @Test
    @DisplayName("test password validation")
    void passwordValidation() {
        assertTrue(Authentication.isValidPassword(password1));
        assertFalse(Authentication.isValidPassword(password2));
    }

    @AfterAll
    public static void close() {
        System.out.println("Finalizing Authentication tests");
    }
}
