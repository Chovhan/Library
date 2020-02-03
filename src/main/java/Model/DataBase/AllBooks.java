package Model.DataBase;

import Model.Objects.Book;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllBooks {

    private static final Logger logger = Logger.getLogger(AllBooks.class);

    public ArrayList<Book> getAllBooksFromDb(){

        logger.info("GetAllBooksFromDb function started!");

        ArrayList<Book> booksList = new ArrayList<>();
        try {
            ResultSet resultSet = getAllBooksSet();
            while (resultSet.next()){
                booksList.add(createBookObject(resultSet));
            }
            logger.info("All books list was created!");
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booksList;
    }

    private Book createBookObject(ResultSet resultSet) throws SQLException {
        return new Book(resultSet.getString("title"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getInt("bookId"),
                resultSet.getInt("bookInstanceId"),
                resultSet.getString("bookAvailibility"));
    }

    private ResultSet getAllBooksSet() throws SQLException {
        PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement("" +
                "Select author.firstName, author.lastName, books.title, bookistance.bookId, bookistance.bookInstanceId, bookistance.bookAvailibility " +
                "from author " +
                "Inner Join (authoring) On author.authorId = authoring.authorId " +
                "Inner Join (books) On authoring.bookId = books.bookId " +
                "Inner Join (bookistance) On bookistance.bookId = books.bookId WHERE bookistance.bookAvailibility = 'Yes';");
        return preparedStatement.executeQuery();
    }
}
