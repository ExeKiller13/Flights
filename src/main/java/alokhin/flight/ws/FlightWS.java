package alokhin.flight.ws;

import alokhin.flight.entities.Directories.City;
import alokhin.flight.entities.Directories.Place;
import alokhin.flight.entities.Objects.Flight;
import alokhin.flight.entities.Objects.Passenger;
import alokhin.flight.entities.Objects.Reservation;
import alokhin.flight.impls.BuyImpl;
import alokhin.flight.impls.CheckImpl;
import alokhin.flight.impls.SearchImpl;
import alokhin.flight.interfaces.Buy;
import alokhin.flight.interfaces.Check;
import alokhin.flight.interfaces.Search;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(serviceName = "FlightService")
public class FlightWS implements Search, Buy, Check {

    private Search searchImpl = new SearchImpl();
    private Buy buyImpl = new BuyImpl();
    private Check checkImpl = new CheckImpl();

    public Reservation checkReservationByCode(String code) {
        return checkImpl.checkReservationByCode(code);
    }

    public ArrayList<Reservation> checkReservationByDocumentNumber(String documentNumber) {
        return checkImpl.checkReservationByDocumentNumber(documentNumber);
    }

    public ArrayList<Reservation> checkReservationByDateReserv(Long date) {
        return checkImpl.checkReservationByDateReserv(date);
    }

    public ArrayList<Reservation> checkReservationByFamilyName(String familyName) {
        return checkImpl.checkReservationByFamilyName(familyName);
    }

    public ArrayList<Flight> searchFlight(Long date, City cityFrom, City cityTo) {
        return searchImpl.searchFlight(date, cityFrom, cityTo);
    }

    public ArrayList<City> getAllCities() {
        return searchImpl.getAllCities();
    }

    public ArrayList<Place> getPlacesBusy(Long aircraft_id, Long flight_id) {
        return searchImpl.getPlacesBusy(aircraft_id, flight_id);
    }

    public ArrayList<Place> getFreePlaces(Long aircraft_id, Long flight_id) {
        return searchImpl.getFreePlaces(aircraft_id, flight_id);
    }

    public Integer buyTicket(Flight flight, Place place, Passenger passenger, String addInfo) {
        return buyImpl.buyTicket(flight, place, passenger, addInfo);
    }
}
