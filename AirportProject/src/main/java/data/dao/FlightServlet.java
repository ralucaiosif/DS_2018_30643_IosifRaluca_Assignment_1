package data.dao;

import data.dto.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private FlightDaoImpl flightDao;

    @Override
    protected void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        ArrayList<Flight> flights = flightDao.findAll();
    }

}
