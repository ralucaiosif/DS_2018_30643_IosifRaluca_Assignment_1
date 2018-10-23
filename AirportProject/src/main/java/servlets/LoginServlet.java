package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Using GET Method to Read Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<body  style=\"background-color:powderblue;\">\n" +
                "<form action = \"HelloForm\" method = \"GET\">" +
                "First Name: <input type = \"text\" name = \"first_name\">" +
                "<br />" +
                "Password: <input type=\"password\" name=\"pwd\">" +
                "<input type = \"submit\" value = \"Login\" />" +
                "</form>" +
                "</body>" +
                "</html>"
        );
    }
}
