package business.BL;

import data.dao.CityDao;
import data.dao.CityDaoImpl;
import data.dto.City;

import java.util.List;

public class CityBL {

    private CityDao cityDao;

    public CityBL(){
        cityDao = new CityDaoImpl();
    }
    public City getCityById(int id) {
        return cityDao.getCityById(id);
    }

    public List<Double> getCityCoordinates(String cityName){
        return cityDao.getCityCoordonates(cityName);
    }

    public City getByName(String cityName){
        return cityDao.getByName(cityName);
    }
}
