package Controller.Servlets;

import Model.DataBase.AddBookTransaction;
import Model.Objects.NewBook;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    public final Logger logger = Logger.getLogger(AddBookServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/AdminAddbook.jsp").forward(req, resp);
        logger.info("AddBookServlet?  - is started!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("AddBookServlet - is started!");
        try {
            new AddBookTransaction().addBook(createBook(req));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/jsp/AdminAddbook.jsp").forward(req, resp);
    }

    public NewBook createBook(HttpServletRequest req) {
        String[] authorName = req.getParameter("author__name").split(" ");
        System.out.println(Arrays.toString(authorName));

        NewBook newBook = new NewBook(req.getParameter("title__name"),
                req.getParameter("ISBN__name"),
                authorName[0],
                authorName[1],
                req.getParameter("birth__date"),
                req.getParameter("country__name-author"),
                req.getParameter("house__name"),
                req.getParameter("country__name-pb"),
                req.getParameter("city__name"),
                req.getParameter("street__name"),
                "Yes");
        return newBook;
    }
}
