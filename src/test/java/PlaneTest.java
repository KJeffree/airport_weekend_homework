import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;
    Passenger passenger;

    @Before
    public void before(){
        plane = new Plane(PlaneType.AIRBUSA320, "EasyJet");
        passenger = new Passenger();
    }

    @Test
    public void canCheckPassengersBooked(){
        assertEquals(0, plane.checkBookedPassengers());
    }

    @Test
    public void addPassengerToPlane(){
        plane.addPassenger(passenger);
        assertEquals(1, plane.checkBookedPassengers());
    }
}
