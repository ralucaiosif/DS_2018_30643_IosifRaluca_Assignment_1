package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    private String message = "hi";

    // Method to handle GET method request.
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Using GET Method to Read Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";

        out.println(docType +
                        "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body bgcolor = \"#f0f0f0\">\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<ul>\n" +
                        "  <li><b>First Name</b>: "
                        + request.getParameter("username") + "\n" +
                        "  <li><b>Last Name</b>: "
                        + request.getParameter("pwd") + "\n" +
                        "</ul>\n" +
                        "</body>" +
                "</html>"
        );
    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        PrintWriter out = response.getWriter();
//        String docType =
//                "<!doctype html public \"-//w3c//dtd html 4.0 " +
//                        "transitional//en\">\n";
//        out.println( docType +
//                "<html>" +
//                "<body>" +
//                "<form action = \"HelloForm\" method = \"POST\">" +
//                "Username: <input type = \"text\" name = \"username\">" +
//                "<br />" +
//                "Password: <input type = \"text\" name = \"pwd\" />" +
//                "<input type = \"submit\" value= \"Submit\" />" +
//                "</form>" +
//                "</body>" +
//                "</html>"
//        );
        doGet(request,response);
    }
}
