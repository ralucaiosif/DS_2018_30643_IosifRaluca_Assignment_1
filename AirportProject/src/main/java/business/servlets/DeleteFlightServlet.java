package business.servlets;

import business.BL.FlightBL;
import data.dto.Flight;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFlightServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        FlightBL flightBL = new FlightBL();
        String flight_id = request.getParameter("flight_id");
        Flight flight = flightBL.getById(Integer.parseInt(flight_id));
        flightBL.deleteFlight(flight);
        Flight deletedFlight = flightBL.getById(Integer.parseInt(flight_id));
        if (deletedFlight == null){
            RequestDispatcher view = request.getRequestDispatcher("/html/success.html");
            view.forward(request, response);
        }
        else{
            RequestDispatcher view = request.getRequestDispatcher("/html/fail.html");
            view.forward(request, response);
        }
    }
}
