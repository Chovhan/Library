package Model.DataBase;

import Model.Objects.Visitor;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Base64;

public class SignUser {

    private static final Logger logger = Logger.getLogger(SignUser.class);

    public void addVisitorToTable(Visitor visitor, byte[] salt){
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(
                    "Insert visitor(firstName, lastName, phoneNumber, email, salt, password, role) " +
                    "Values (?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, visitor.getFirstName());
            preparedStatement.setString(2, visitor.getLastName());
            preparedStatement.setString(3, visitor.getPhoneNumber());
            preparedStatement.setString(4, visitor.getEmail());
            preparedStatement.setString(5, new String(Base64.getEncoder().encode(salt)));
            preparedStatement.setString(6, visitor.getPassword());
            preparedStatement.setString(7, visitor.getRole());

            preparedStatement.executeUpdate();
            logger.info("user was added to data base!");
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("SQLException: " + e);
        }
    }

    public boolean checkUserInDb(Visitor visitor){
        boolean isUserExist = false;
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement("select visitorId " +
                    "from visitor where phoneNumber=(?) and email=(?)");
            preparedStatement.setString(1, visitor.getPhoneNumber());
            preparedStatement.setString(2, visitor.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                isUserExist = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("SQLException: " + e);
        }
        return isUserExist;
    }
}
