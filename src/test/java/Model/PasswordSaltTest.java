package Model;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

public class PasswordSaltTest {

    @Test
    public void generateHashFroEqual() throws NoSuchAlgorithmException {
        PasswordSalt passwordSalt = new PasswordSalt();
        byte[] salt = {21, 102, -36, -63, -103, 65, 82, -41, 51, -56, 117, 38, -14, 117, -45, -51, 42, -31, -120, -128};
        String actual = PasswordSalt.generateHash("33New11Password22", salt);
        String expected = "6A7434633BAE1D2C2E73EDEF3A909345";
        assertEquals("Check string for equal", expected, actual);
    }

    @Test
    public void generateHashNotForNull() throws NoSuchAlgorithmException {
        byte[] salt = {21, 102, -36, -63, -103, 65, 82, -41, 51, -56, 117, 38, -14, 117, -45, -51, 42, -31, -120, -128};
        String actual = PasswordSalt.generateHash("33New11Password22", salt);
        assertNotNull("Check string for not null", actual);
    }

    @Test
    public void bytesToStringHexNotForNull() {
        PasswordSalt passwordSalt = new PasswordSalt();
        byte[] bytes = passwordSalt.createSalt();
        String result = PasswordSalt.bytesToStringHex(bytes);
        assertNotNull("Check gor mot null string", result);
    }

    @Test
    public void createSaltForNotNull() {
        byte[] bytes = new PasswordSalt().createSalt();
        assertNotNull("Check for null byte array", bytes);
    }
}