package data.dto;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Flight {
    @Id
    private int flightNumber;
    private AirplaneType airplaneType;
    private City departureCity;
    private LocalDate departureDate;
    private LocalTime departureHour;
    private City arrivalCity;
    private LocalDate arrivalDate;
    private LocalTime arrivalHour;

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public AirplaneType getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(LocalTime departureHour) {
        this.departureHour = departureHour;
    }

    public City getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(LocalTime arrivalHour) {
        this.arrivalHour =arrivalHour;
    }
}
