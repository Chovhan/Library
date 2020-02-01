package Model.DataBase;

import Model.Objects.Book;
import Model.Objects.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class TakeBookTransaction {

    private static final Logger logger = Logger.getLogger(TakeBookTransaction.class);

    public void changeBookStatus(int userId, int bookInstanceId) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        Savepoint savepoint = null;
        try {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("StartTransaction");
            System.out.println("Creating save point");

            addNoteToDb(connection, userId, bookInstanceId);

            changeTableInDb(connection, bookInstanceId);

//            setBookGiveTimeIdVar(connection, bookInstanceId);

            createEventInDb(connection, bookInstanceId);

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback(savepoint);
        }
        connection.close();
    }

    public void addNoteToDb(Connection connection, int userId, int bookInstanceId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "Insert bookgivetime(giveTime, visitorId, bookInstanceId) Values (Now(), ?, ?);");
        preparedStatement.setString(1, String.valueOf(userId));
        preparedStatement.setString(2, String.valueOf(bookInstanceId)); // Set bookInstanceId
        preparedStatement.executeUpdate();
    }

    public void changeTableInDb(Connection connection, int bookInstanceId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("" +
                "UPDATE bookistance SET bookAvailibility = (?) WHERE bookInstanceId = (?)");
        preparedStatement.setString(1, "No");
        preparedStatement.setString(2, String.valueOf(bookInstanceId)); //Set bookInstanceId
        preparedStatement.executeUpdate();
    }

//    public void setBookGiveTimeIdVar(Connection connection, int bookInstanceId) throws SQLException {
//        PreparedStatement setVar = connection.prepareStatement(
//                "Set @giveTimeId = (Select bookgivetime.bookGiveTimeId from bookgivetime where bookgivetime.bookInstanceId = (?));");
//        setVar.setInt(1, bookInstanceId);
//        setVar.executeUpdate();
//    }

    public void createEventInDb(Connection connection, int bookInstanceId) throws SQLException {
        PreparedStatement newEvent = connection.prepareStatement(
                "Create Event myevent" + bookInstanceId + " " +
                        "On Schedule AT CURRENT_TIMESTAMP + INTERVAL 10 SECOND " +
                        "Do " +
                        "Begin " +
                        "UPDATE bookistance SET bookAvailibility = 'Yes' WHERE bookInstanceId = (?); " +
                        "End;");
        newEvent.setInt(1, bookInstanceId);
        newEvent.executeUpdate();
    }

//    public void createШтыукеEventInDb(Connection connection, int bookInstanceId) throws SQLException {
//        PreparedStatement newEvent = connection.prepareStatement(
//                "Create Event insertEvent" + bookInstanceId + " " +
//                        "On Schedule AT CURRENT_TIMESTAMP + INTERVAL 40 SECOND " +
//                        "Do " +
//                        "Begin " +
//                        "Insert booktaketime(takeTime, bookGiveTimeId, bookInstanceId) Values (Now(), @giveTimeId, ?); " +
//                        "End;");
//        newEvent.setInt(1, bookInstanceId);
//        newEvent.executeUpdate();
//    }
}
