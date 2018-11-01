package business.servlets;

import business.BL.CityBL;
import business.BL.FlightBL;
import business.BL.UserBL;
import data.dto.Flight;
import data.dto.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        RequestDispatcher view = request.getRequestDispatcher("/html/login.html");
        // don't add your web-app name to the path

        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserBL userBL = new UserBL();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userBL.login(username, password);
        if (user == null) {
            response.sendRedirect("/invalid-credentials");
        } else if (user.getRole().equals("admin")) {
            response.sendRedirect("/admin-page");
        } else {
            response.sendRedirect("/user-page");

        }

    }

    private String computeAdminPage(ArrayList<Flight> flights) {

        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        String html = docType +
                computeHtmlFlightsTable(flights) +
                "<form action = \"/add-flight\" method = \"post\">\n" +
                "<input type = \"submit\" value = \"Add flight\">\n" +
                "</form >" +
                "<form action = \"/update-flight\" method = \"post\">\n" +
                "<input type = \"submit\" value = \"Update flight\">\n" +
                "</form >" +
                "<form action = \"/delete-flight\" method = \"post\">\n" +
                "<input type = \"submit\" value = \"Delete flight\">\n" +
                "</form >\n" +
                "</body>\n" +
                "</html>\n";
        return html;
    }


    private String computeHtmlFlightsTable(ArrayList<Flight> flights) {
        String html = "<html>\n" +
                "<head><title>" + "Flights" + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<table stype=\"width:100%\">\n" +
                "<tr>\n" +
                "<th> ID </th>\n" +
                "<th> Airplane type </th>\n" +
                "<th> Departure city </th>\n" +
                "<th> Departure day </th>\n" +
                "<th> Departure hour </th>\n" +
                "<th> Arrival city </th>\n" +
                "<th> Arrival day </th>\n" +
                "<th> Arrival hour </th>\n";
        CityBL cityBL = new CityBL();

        for (Flight f : flights) {
            List<String> cityNames = new ArrayList<>();

            cityNames.add(cityBL.getCityById(f.getDepartureCity()).getName());
            cityNames.add(cityBL.getCityById(f.getArrivalCity()).getName());
            html += "<tr>\n<td>" + f.getFlightId() + "</td>\n" +
                    "<td>" + f.getAirplaneType().toString() + "</td>\n" +
                    "<td>" + cityNames.get(0) + "</td>\n" +
                    "<td>" + f.getDepartureDate().toString() + "</td>\n" +
                    "<td>" + f.getDepartureHour().toString() + "</td>\n" +
                    "<td>" + cityNames.get(1) + "</td>\n" +
                    "<td>" + f.getArrivalDate().toString() + "</td>\n" +
                    "<td>" + f.getArrivalHour().toString() + "</td>\n" +
                    "</tr>\n";
        }
        html += "</table>\n";
        return html;
    }
}
