import java.util.ArrayList;

public class Airport {

    private ArrayList<Plane> hangers;
    private String airportCode;

    public Airport(){
        this.hangers = new ArrayList<>();
        this.airportCode = "EDI";
    }

    public Flight createFlight(int flightNumber, DestinationType destination){
        String continent = destination.getContinent();
        Plane bestPlane = null;
        for (Plane plane : this.hangers){
            int planeCapacity = plane.getType().getCapacity();
            if (continent == plane.getType().getContinent()){
                if (bestPlane == null){
                    bestPlane = plane;
                } else if (bestPlane.getType().getCapacity() < planeCapacity){
                    bestPlane = plane;
                }
            }
        }
        this.hangers.remove(bestPlane);
        return new Flight(bestPlane, flightNumber, destination);
    }

    public int checkPlanesInHanger(){
        return this.hangers.size();
    }

    public void addPlaneToHanger(Plane plane){
        this.hangers.add(plane);
    }

    public void sellTicket(Flight flight, Passenger passenger){
        if (flight.getTicketsSoldSize() != flight.getPlane().getType().getCapacity()){
            flight.getTicketsSold().add(passenger);
        } else {
            System.out.println("Flight Fully Booked");
        }
    }

    public void replaceBrokenPlane(Flight flight){
        int planeCapacity = flight.getPlane().getType().getCapacity();
        Plane bestPlane = null;
        for (Plane plane : this.hangers){
            int newCapacity = plane.getType().getCapacity();
            if (newCapacity < planeCapacity && bestPlane == null){
                bestPlane = plane;
            } else if (newCapacity < planeCapacity && newCapacity > bestPlane.getType().getCapacity()) {
                bestPlane = plane;
            }
        }
        this.hangers.remove(bestPlane);
        flight.setPlane(bestPlane);
    }
}
