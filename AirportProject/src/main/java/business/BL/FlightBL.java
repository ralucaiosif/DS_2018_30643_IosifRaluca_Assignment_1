package business.BL;

import data.dao.FlightDao;
import data.dao.FlightDaoImpl;
import data.dto.Flight;

import java.util.ArrayList;

public class FlightBL {

    private FlightDao flightDao;

    public FlightBL(){
        flightDao = new FlightDaoImpl();
    }

    public ArrayList<Flight> findAll(){
        return flightDao.findAll();
    }

    public Flight addFlight(Flight flight){
        return flightDao.addFlight(flight);
    }

    public void deleteFlight(Flight flight){
        flightDao.deleteFlight(flight);
    }

    public Flight getById(int id){
        return flightDao.getById(id);
    }

    public void updateFlight(Flight flight){
        flightDao.updateFlight(flight);
    }

}
