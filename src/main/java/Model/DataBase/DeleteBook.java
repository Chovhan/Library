package Model.DataBase;

import org.apache.log4j.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBook {

    private static final Logger logger = Logger.getLogger(DeleteBook.class);

    public void deleteBookFromDb(int bookId){
        try {
            PreparedStatement deleteBook = ConnectionPool.getConnection().prepareStatement(
                    "Delete From books Where books.bookId=(?)");
            deleteBook.setInt(1, bookId);
            deleteBook.executeUpdate();
            logger.info("Book was deleted!");
            deleteBook.close();
        } catch (SQLException e) {
            System.out.println("We have some problems with query!");
            logger.error("SQLException: " + e);
        }
    }

}
