package business.servlets;

import business.BL.CityBL;
import business.BL.FlightBL;
import data.dto.AirplaneType;
import data.dto.Flight;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class SaveFlightServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Flight flight = getFlight(request);

        FlightBL flightBL = new FlightBL();
        flight = flightBL.addFlight(flight);
        boolean ok = false;
        if (flight.getFlightId()!= 0){
            ok = true;
        }

        PrintWriter out = response.getWriter();

        if (ok){
            RequestDispatcher view = request.getRequestDispatcher("/html/success.html");
            view.forward(request, response);
        }
        else{
            RequestDispatcher view = request.getRequestDispatcher("/html/error.html");
            view.forward(request, response);
        }
    }

    private Flight getFlight(HttpServletRequest request) {
        Flight flight = new Flight();
        flight.setAirplaneType(AirplaneType.valueOf(request.getParameter("airplane_type")));

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        //convert String to LocalDate
        flight.setDepartureDate(LocalDate.parse(request.getParameter("departure_day")));

        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        flight.setDepartureHour(LocalTime.parse(request.getParameter("departure_hour")));

        flight.setArrivalDate(LocalDate.parse(request.getParameter("arrival_day")));

        flight.setArrivalHour(LocalTime.parse(request.getParameter("arrival_hour")));

        CityBL cityBL = new CityBL();
        int departureCityId = cityBL.getByName(request.getParameter("departure_city")).getId();
        flight.setDepartureCity(departureCityId);

        int arrivalCityId = cityBL.getByName(request.getParameter("arrival_city")).getId();
        flight.setArrivalCity(arrivalCityId);
        return flight;
    }
}
