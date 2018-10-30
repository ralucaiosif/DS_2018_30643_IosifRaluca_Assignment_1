package start;

import data.connection.DBConnection;
import data.dao.UserDao;
import data.dao.UserDaoImpl;
import data.dto.Flight;
import data.dto.User;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MainClass {

    private static SessionFactory factory;
    public static void main(String[] args){
        Flight f = new Flight();
        f.setDepartureDate(LocalDate.now());
        System.out.println(f.getDepartureDate());
        //Session session = DBConnection.connectToDB();
        SessionFactory factory = DBConnection.connectToDB();
        if (factory!= null){
            System.out.println("session opened");
            UserDao udao = new UserDaoImpl(factory);
            User user = udao.login("alex", "1234");
        }

    }
}
