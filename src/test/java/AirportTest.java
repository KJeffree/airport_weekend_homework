import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {
    Airport airport;
    Plane plane1;
    Plane plane2;
    Plane plane3;
    Plane plane4;
    Plane plane5;
    Plane plane6;
    Plane plane7;
    Flight flight;
    Passenger passenger;

    @Before
    public void before() {
        airport = new Airport();
        plane1 = new Plane(PlaneType.BOEING737, "EasyJet");
        flight = new Flight(plane1, 208, DestinationType.ITALY);
        passenger = new Passenger();
        plane2 = new Plane(PlaneType.AIRBUSA320, "EasyJet");
        plane3 = new Plane(PlaneType.BOEING777, "EasyJet");
        plane4 = new Plane(PlaneType.AIRBUSA340, "EasyJet");
        plane5 = new Plane(PlaneType.BOEING747, "EasyJet");
        plane6 = new Plane(PlaneType.AIRBUSA380, "EasyJet");
        plane7 = new Plane(PlaneType.BOEING787, "EasyJet");
        airport.addPlaneToHanger(plane1);
        airport.addPlaneToHanger(plane2);
        airport.addPlaneToHanger(plane3);
        airport.addPlaneToHanger(plane4);
        airport.addPlaneToHanger(plane5);
        airport.addPlaneToHanger(plane6);
        airport.addPlaneToHanger(plane7);
    }

    @Test
    public void canCreateFlight(){
        Flight flight = airport.createFlight(165, DestinationType.FRANCE);
        assertEquals(350, flight.getPlane().getType().getCapacity());
        assertEquals(165, flight.getFlightNumber());
        assertEquals(DestinationType.FRANCE, flight.getDestination());
    }

    @Test
    public void hangerStartsWith7Planes(){
        assertEquals(7, airport.checkPlanesInHanger());
    }

    @Test
    public void canAddPlaneToHanger(){
        airport.addPlaneToHanger(plane1);
        assertEquals(8, airport.checkPlanesInHanger());
    }

    @Test
    public void canAssignPlaneToFlightFromHanger(){
        Flight flight = airport.createFlight(165, DestinationType.FRANCE);
        assertEquals(350, flight.getPlane().getType().getCapacity());
    }

    @Test
    public void canSellTicketsForFlights(){
        airport.sellTicket(flight, passenger);
        assertEquals(1, flight.getTicketsSoldSize());
    }

    @Test
    public void canFillFlight(){
        for (int i = 0; i < 162; i++){
            airport.sellTicket(flight, passenger);
        }
        assertEquals(162, flight.getTicketsSoldSize());
    }

    @Test
    public void cannotSellTicketIfFlightFull(){
        for (int i = 0; i < 162; i++){
            airport.sellTicket(flight, passenger);
        }
        airport.sellTicket(flight, passenger);
        assertEquals(162, flight.getTicketsSoldSize());
    }

    @Test
    public void canAssignSuitablePlaneForDestination(){
        Flight flight = airport.createFlight(532, DestinationType.ITALY);
        assertEquals(PlaneType.AIRBUSA340, flight.getPlane().getType());
        assertEquals(6, airport.checkPlanesInHanger());
    }

    @Test
    public void canAssignSecondPlaneIfFirstBrokenDown(){
        Flight flight = airport.createFlight(342, DestinationType.ITALY);
        airport.replaceBrokenPlane(flight);
        assertEquals(5, airport.checkPlanesInHanger());
        assertEquals(PlaneType.BOEING777, flight.getPlane().getType());
    }

}
