package start;

import data.DBConnection;
import data.dto.Flight;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MainClass {

    public static void main(String[] args){
        Flight f = new Flight();
        f.setDepartureDate(LocalDate.now());
        System.out.println(f.getDepartureDate());
        DBConnection.connect();
    }
}
