package business.servlets;

import business.BL.CityBL;
import business.BL.FlightBL;
import data.dto.Flight;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AdminFlightsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FlightBL flightBL = new FlightBL();
        ArrayList<Flight> flights = flightBL.findAll();
        PrintWriter out = response.getWriter();
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                computeHtmlFlightsTable(flights) +
                "<form action = \"/update-flight\" method = \"post\" >\n" +
                "<input type = \"submit\" value = \"Update flight\" >\n" +
                "</form >" +
                "<form action = \"/delete-flight\" method = \"post\" >\n" +
                "<label id=\"flight_id\"> Flight ID </label>\n" +
                "<br>\n" +
                "<input name=\"flight_id\" type=\"text\"/>\n" +
                "<br>" +
                "<input type = \"submit\" value = \"Delete flight\" >\n" +
                "</form >" +
                "</body>\n" +
                "</html>\n"

        );
    }

    public String computeHtmlFlightsTable(ArrayList<Flight> flights){
        String htmlString =   "<html>\n" +
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
            htmlString += "<tr>\n<td>" + f.getFlightId() + "</td>\n" +
                    "<td>" + f.getAirplaneType().toString() + "</td>\n" +
                    "<td>" + cityNames.get(0)+ "</td>\n" +
                    "<td>" + f.getDepartureDate().toString() + "</td>\n" +
                    "<td>" + f.getDepartureHour().toString() + "</td>\n" +
                    "<td>" + cityNames.get(1) + "</td>\n" +
                    "<td>" + f.getArrivalDate().toString() + "</td>\n" +
                    "<td>" + f.getArrivalHour().toString() + "</td>\n" +
                    "</tr>\n";
        }
        htmlString+= "</table>\n";
        return htmlString;
    }

}
