package Model.DataBase;

import Model.Objects.User;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUser {

    private static final Logger logger = Logger.getLogger(LoginUser.class);

    public User checkUserInDb(String email){
        User user = null;
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement("select * from " +
                    "visitor where email=(?)");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                user = new User(resultSet.getString("email"),
                        resultSet.getString("salt"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getInt("visitorId"));
                logger.info("User object was created!");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("SQLException: " + e);
        }
        return user;
    }
}
