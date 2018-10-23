package data.dto;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "Flight")
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id", nullable = false)
    private int flightNumber;

    private AirplaneType airplaneType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City departureCity;

    private LocalDate departureDate;

    private LocalTime departureHour;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
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
