package Controller.Servlets;

import Controller.Interfaces.ILogInSubmit;
import Controller.LogInSubmit;
import Model.DataBase.LoginUser;
import Model.Objects.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/Login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("Log-in__email");
        String password = req.getParameter("Log-in__password");

        HttpSession loginSession = req.getSession();
        if (loginSession.getAttribute("User") == null | loginSession.getAttribute("Admin") == null){
            User user = new LoginUser().checkUserInDb(email);
            ILogInSubmit logInSubmit = new LogInSubmit();
            if (logInSubmit.submitUser(password, user)){
                System.out.println(user.getRole());
                loginSession.setAttribute(user.getRole(), user);
                System.out.println(loginSession.getAttribute("Admin"));
//                logger.info("User was authorise!");
                moveToPage(resp, user.getRole());
            } else {
                doGet(req, resp);
            }
        }
    }

    public void moveToPage(HttpServletResponse resp, String role) throws IOException {
        resp.sendRedirect("/" + role);
    }
    // base64  "$345$salt$bytes"
}
