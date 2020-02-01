package Controller.Servlets;

import Model.DataBase.DeleteBook;
import Model.DataBase.AllBooks;
import Model.Objects.Book;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/allBooks")
public class AllBooksServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AllBooksServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("AddBookServlet, doGet method - is started!");

        ArrayList<Book> books = new AllBooks().getAllBooksFromDb();
        logger.info("List with all books was created");
        req.setAttribute("allBooks", books);
        req.getRequestDispatcher("/jsp/AdminAllBooks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("AddBookServlet, doPost method - is started!");

        int bookId = Integer.parseInt(req.getParameter("delete__book"));
        new DeleteBook().deleteBookFromDb(bookId);
        doGet(req, resp);
    }
}
