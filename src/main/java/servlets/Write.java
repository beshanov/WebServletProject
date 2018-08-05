package servlets;

import database.DBConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/blog/Write")
public class Write extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        DBConnector dbConnector = new DBConnector();

        if(dbConnector.getPasswords().contains(request.getParameter("password"))) {
            dbConnector.addEntry(request.getParameter("data"));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/blog/add_data.html");
        dispatcher.forward(request, response);
    }

}
