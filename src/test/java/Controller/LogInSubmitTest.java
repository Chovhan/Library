package Controller;

import Model.Objects.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogInSubmitTest {

    @Test
    public void submitUser() {
        User user = new User("petro@gmail.com", "q+3zBdoAnLeiy7KOkGA7imqHeG0=", "30AAA46EA259D25FEEC7238FE169EEC8", "User", 22);
        boolean expected = true;
        boolean actual = new LogInSubmit().submitUser("22550hage", user);
        assertEquals("My test", expected, actual);
    }

    @Test
    public void submitUserTestForTrue() {
        User user = new User("petro@gmail.com", "q+3zBdoAnLeiy7KOkGA7imqHeG0=", "30AAA46EA259D25FEEC7238FE169EEC8", "User", 22);
        boolean actual = new LogInSubmit().submitUser("22550hage", user);
        assertTrue("My test", actual);
    }

    @Test
    public void submitUserTestForFalse() {
        User user = new User("petro@gmail.com", "q+3zBdoAnLeiy7KOkGA7imqHeG0=", "30AAA46EA259D25FEEC7238FE169EEC8", "User", 22);
        boolean actual = new LogInSubmit().submitUser("22550he", user);
        assertFalse("My test", actual);
    }
}