package business.servlets;

import business.BL.UserBL;
import data.connection.DBConnection;
import data.dao.UserDao;
import data.dao.UserDaoImpl;
import data.dto.User;

import javax.servlet.RequestDispatcher;
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
        /*String title = "Using GET Method to Read Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(HtmlString.docType + HtmlString.loginHtml);*/

        RequestDispatcher view = request.getRequestDispatcher("/html/login.html");
        // don't add your web-app name to the path

        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserBL userBL = new UserBL();
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        User user = userBL.login(username, password);
        if (user.getRole().equals("admin")) {
            //TODO
            // admin html page -> CRUD on flights
        } else {
            // user html page -> view flights ?
        }
        PrintWriter out = response.getWriter();
        String title = "Welcome Page";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + "helloo" + "</h1>\n" +
                "</body>" +
                "</html>"
        );



    }
}
