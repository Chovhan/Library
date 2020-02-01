package Controller.Servlets;

import Model.DataBase.TakenBooks;
import Model.Objects.DataTransfer;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AdminServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<DataTransfer> dataTransfers = new TakenBooks().getDataTransfer();
        logger.info("DataTransfer list was created!");
        req.setAttribute("dataTransferArray", dataTransfers);
        req.getRequestDispatcher("/jsp/Admin.jsp").forward(req, resp);
    }


}
