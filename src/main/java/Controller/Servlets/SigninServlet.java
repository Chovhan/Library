package Controller.Servlets;

import Controller.SignInSubmit;
import Model.DataBase.SignUser;
import Model.Objects.Visitor;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sing")
public class SigninServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(SigninServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/LoginServlet.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SignInSubmit signInSubmit = new SignInSubmit();
        byte[] salt = signInSubmit.getSalt();

        Visitor visitor = new Visitor(req.getParameter("Signup__name"),
                req.getParameter("Signup__surname"),
                req.getParameter("Signup__tel"),
                req.getParameter("Signup__email"),
                signInSubmit.saltPasswords(req.getParameter("Signup__password"), salt),
                "User");

        logger.info("User object is created!");


        SignUser signUser = new SignUser();
        if (signUser.checkUserInDb(visitor)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/books.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            signUser.addVisitorToTable(visitor, salt);
            logger.info("User was added to Data Base!");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/Servlet.jsp");
        requestDispatcher.forward(req, resp);
    }

}

