package servlets;

import database.DBConnector;
import entities.Entry;
import json.JsonWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/blog/Show")
public class Show extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        super.doPost(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        DBConnector dbConnector = new DBConnector();
        //ServletOutputStream outputStream = response.getOutputStream();
        //outputStream.print(JsonWriter.returnEntryListJson(dbConnector.getAllEntries()));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JsonWriter.returnEntryListJson(dbConnector.getAllEntries()));

      /*  PrintWriter out = response.getWriter();
        for(Entry entry: dbConnector.getAllEntries()) {
            out.println(entry);
        }*/
    }
}
