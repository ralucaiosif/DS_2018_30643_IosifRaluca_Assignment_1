package data.dao;

import data.dto.Flight;

import java.util.ArrayList;

public interface FlightDao {

    ArrayList<Flight> findAll();
    Flight addFlight(Flight flight);
    Flight getById(int id);
    void deleteFlight(Flight flight);
    void updateFlight(Flight flight);
}
