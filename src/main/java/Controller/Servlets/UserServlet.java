package Controller.Servlets;

import Model.DataBase.TakeBookTransaction;
import Model.Objects.Book;
import Model.DataBase.AllBooks;
import Model.Objects.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/User")
public class UserServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Book> books = new AllBooks().getAllBooksFromDb();
        logger.info("All books list for user was created!");
        req.setAttribute("allBooks", books);
        req.getRequestDispatcher("/jsp/User.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookInstanceId = Integer.parseInt(req.getParameter("take-number__book"));
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        try {
            new TakeBookTransaction().changeBookStatus(user.getId(), bookInstanceId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(req, resp);

    }
}
