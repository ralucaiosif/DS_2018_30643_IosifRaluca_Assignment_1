package data.dao;

import data.dto.City;

import java.util.List;

public interface CityDao {

   City getCityById(int id);
   List<Double> getCityCoordonates(String cityName);
   City getByName(String cityName);
}
