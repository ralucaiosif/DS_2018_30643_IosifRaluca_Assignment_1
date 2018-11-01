package data.dao;

import data.dto.Flight;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightDaoImpl extends AbstractDAO implements FlightDao {


    @Override
    public ArrayList<Flight> findAll() {
        /*ArrayList<Flight> flights = new ArrayList<>();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Flight f");
        flights = (ArrayList<Flight>) query.list();
        return flights;*/
        CriteriaQuery<Flight> criteriaQuery = getSession().getCriteriaBuilder().createQuery(Flight.class);
        criteriaQuery.from(Flight.class);
        return (ArrayList<Flight>) getSession().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Flight addFlight(Flight flight) {
       getSession().beginTransaction();
       getSession().save(flight);
       getSession().getTransaction().commit();
       return flight;
    }

    @Override
    public Flight getById(int id) {
        return getSession().get(Flight.class, id);
    }

    @Override
    public void deleteFlight(Flight flight) {
        getSession().beginTransaction();
        getSession().delete(flight);
        getSession().getTransaction().commit();
        getSession().close();
    }

    @Override
    public void updateFlight(Flight flight) {
        getSession().beginTransaction();
        getSession().merge(flight);
        getSession().getTransaction().commit();
        getSession().close();
    }
}
