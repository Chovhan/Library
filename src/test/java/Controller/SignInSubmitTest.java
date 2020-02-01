package Controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignInSubmitTest {

    @Test
    public void getSalt() {
        byte[] salt = new SignInSubmit().getSalt();
        assertNotNull("Create salt", salt);
    }

    @Test
    public void saltPasswords() {
        String saltPassword = new SignInSubmit().saltPasswords("33New11Password22", new SignInSubmit().getSalt());
        assertNotNull("Salt password", saltPassword);
    }

    @Test
    public void saltPasswordsTestForEquals() {
        byte[] salt = {21, 102, -36, -63, -103, 65, 82, -41, 51, -56, 117, 38, -14, 117, -45, -51, 42, -31, -120, -128};
        String actual = new SignInSubmit().saltPasswords("33New11Password22", salt);
        String expected = "6A7434633BAE1D2C2E73EDEF3A909345";
        assertEquals("Check algorithm for equals", expected, actual);
    }
}