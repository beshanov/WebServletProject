package servlets;

import database.LoginDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/blog/Login")
public class Login extends HttpServlet{

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(LoginDao.validate(email, password))
        {
            RequestDispatcher rs = request.getRequestDispatcher("/blog/main.html");
            rs.forward(request, response);
        }
        else
        {
            out.println("Username or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("/blog/login.html");
            rs.include(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
