package data.dao;

import data.dto.Flight;

import java.util.ArrayList;

public interface FlightDao {

    ArrayList<Flight> findAll();

}
