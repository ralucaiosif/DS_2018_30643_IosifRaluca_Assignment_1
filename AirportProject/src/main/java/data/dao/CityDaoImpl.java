package data.dao;

import data.dto.City;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl extends AbstractDAO implements CityDao {

    @Override
    public City getCityById(int id) {
        return  getSession().get(City.class, id);
    }

    @Override
    public List<Double> getCityCoordonates(String cityName) {
        Query query = getSession().createQuery("select c FROM City c  WHERE c.name = :name ");
        query.setParameter("name", cityName);

        City city = (City) query.uniqueResult();
        List<Double> coord = new ArrayList<>();
        coord.add(city.getLongitude());
        coord.add(city.getLatitude());
        return coord;
    }

    @Override
    public City getByName(String cityName) {
        Query query = getSession().createQuery("select c FROM City c  WHERE c.name = :name ");
        query.setParameter("name", cityName);
        return (City) query.uniqueResult();
    }

}
