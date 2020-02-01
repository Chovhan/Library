package Controller;

import Model.PasswordSalt;
import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignInSubmit implements Controller.Interfaces.SignInSubmit {

    private static final Logger logger = Logger.getLogger(SignInSubmit.class);


    @Override
    public byte[] getSalt(){
        logger.info("Salt for sign-in user was created!");
        return new PasswordSalt().createSalt();
    }

    @Override
    public String saltPasswords(String password, byte[] salt){
        String hashPassword = null;
        try {
            hashPassword = PasswordSalt.generateHash(password, salt);
            logger.info("Password was hashed!");
            System.out.println(Arrays.toString(salt) + "\n" + "Salt password: " + hashPassword);
        } catch (NoSuchAlgorithmException e) {
            logger.error("NoSuchAlgorithmException: " + e);
        }
        return hashPassword;
    }
}
