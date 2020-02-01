package Controller.Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogOut")
public class LogOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(session);
        if (session.getAttribute("User") != null){
            session.removeAttribute("User");
        } else if (session.getAttribute("Admin") != null) {
            session.removeAttribute("Admin");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login");
        requestDispatcher.forward(req, resp);
    }
}
