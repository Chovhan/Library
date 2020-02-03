package Model.DataBase;

import Model.Objects.DataTransfer;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TakenBooks {

    private static final Logger logger = Logger.getLogger(TakenBooks.class);

    public ArrayList<DataTransfer> getDataTransfer(){
        ArrayList<DataTransfer> dataTransfersArray = new ArrayList<>();
        try {
            Connection connection = ConnectionPool.getConnection();
            dataTransfersArray = fillDataTransferArray(getResultSet(connection));
            System.out.println(dataTransfersArray);
        } catch (SQLException e) {
            logger.error("SQLException: " + e);
        }
        return dataTransfersArray;
    }

    private ResultSet getResultSet(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "Select books.title, author.firstName, author.lastName, bookgivetime.bookInstanceId, " +
                        "bookgivetime.giveTime, visitor.firstName, visitor.lastName, visitor.phoneNumber, visitor.email " +
                        "from bookgivetime " +
                        "Inner Join (visitor, bookistance, books, authoring, author) " +
                        "On visitor.visitorId = bookgivetime.visitorId " +
                        "and bookgivetime.bookInstanceId = bookistance.bookInstanceId " +
                        "and bookistance.bookId = books.bookId " +
                        "and books.bookId = authoring.bookId " +
                        "and authoring.authorId = author.authorId " +
                        "where bookistance.bookAvailibility = 'No';");
        return statement.executeQuery();
    }

    private ArrayList<DataTransfer> fillDataTransferArray(ResultSet resultSet) throws SQLException {
        ArrayList<DataTransfer> dataTransferArrayList = new ArrayList<>();
        while (resultSet.next()) {
            DataTransfer dataTransfer = new DataTransfer(
                    resultSet.getString("title"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("bookInstanceId"),
                    resultSet.getString("giveTime"),
                    resultSet.getString("visitor.firstName"),
                    resultSet.getString("visitor.lastName"),
                    resultSet.getString("visitor.PhoneNumber"),
                    resultSet.getString("visitor.email"));
            dataTransferArrayList.add(dataTransfer);
        }
        logger.info("Data transfer list was created!");
        return dataTransferArrayList;
    }

}
