package Controller;

import Model.PasswordSalt;
import Model.Objects.User;
import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class LogInSubmit implements Controller.Interfaces.ILogInSubmit {

    private static final Logger logger = Logger.getLogger(LogInSubmit.class);

    @Override
    public boolean submitUser(String password, User user){
        boolean passwordEquals = false;
        String userPasswordFromForm;
        try {
            byte[] salt = Base64.getDecoder().decode(user.getSalt());
            logger.info("Salt from db was decoded!");
            userPasswordFromForm = PasswordSalt.generateHash(password, salt);
            System.out.println(userPasswordFromForm);
            if (userPasswordFromForm.equals(user.getPassword())){
                passwordEquals = true;
                logger.info("User was find in data base!");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("NoSuchAlgorithmException: " + e);
        }
        return passwordEquals;
    }
}
