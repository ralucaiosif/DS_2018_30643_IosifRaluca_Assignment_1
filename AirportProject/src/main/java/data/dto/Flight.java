package data.dto;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id", nullable = false)
    private int flightId;

    @Enumerated(EnumType.STRING)
    private AirplaneType airplaneType;

    @OneToOne
    @Column(name = "departure_city")
    private City departureCity;

    @OneToOne
    @Column(name = "arrival_city")
    private City arrivalCity;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "departure_hour")
    private LocalTime departureHour;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "arrival_hour")
    private LocalTime arrivalHour;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
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
        this.arrivalHour = arrivalHour;
    }
}
