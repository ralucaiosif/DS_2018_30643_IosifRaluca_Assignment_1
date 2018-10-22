package data.dao;

import data.dto.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FlightDao {

    public ArrayList<Flight> findAll();

}
