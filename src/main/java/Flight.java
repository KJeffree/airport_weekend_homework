import java.util.ArrayList;

public class Flight {

    private Plane plane;
    private int flightNumber;
    private DestinationType destination;
    private ArrayList<Passenger> ticketsSold;

    public Flight(Plane plane, int flightNumber, DestinationType destination){
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.ticketsSold = new ArrayList<>();
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public DestinationType getDestination() {
        return destination;
    }

    public ArrayList<Passenger> getTicketsSold() {
        return this.ticketsSold;
    }

    public int getTicketsSoldSize(){
        return this.ticketsSold.size();
    }
}
