import java.util.ArrayList;
import java.util.Scanner;

public class AirlineManagementSystem {
    
    static class Flight {
        private String flightNumber;
        private String destination;
        private int seatsAvailable;

        public Flight(String flightNumber, String destination, int seatsAvailable) {
            this.flightNumber = flightNumber;
            this.destination = destination;
            this.seatsAvailable = seatsAvailable;
        }

        public String getFlightNumber() {
            return flightNumber;
        }

        public String getDestination() {
            return destination;
        }

        public int getSeatsAvailable() {
            return seatsAvailable;
        }

        public void bookTicket(int seats) {
            if (seats <= seatsAvailable) {
                seatsAvailable -= seats;
                System.out.println("Booking successful! Seats booked: " + seats);
            } else {
                System.out.println("Not enough seats available.");
            }
        }

        @Override
        public String toString() {
            return "Flight Number: " + flightNumber + ", Destination: " + destination + ", Seats Available: " + seatsAvailable;
        }
    }

    private ArrayList<Flight> flights = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addFlight() {
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter number of seats available: ");
        int seatsAvailable = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Flight flight = new Flight(flightNumber, destination, seatsAvailable);
        flights.add(flight);
        System.out.println("Flight added successfully!");
    }

    public void bookTicket() {
        System.out.print("Enter flight number to book: ");
        String flightNumber = scanner.nextLine();
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            System.out.print("Enter number of seats to book: ");
            int seats = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            flight.bookTicket(seats);
        } else {
            System.out.println("Flight not found.");
        }
    }

    private Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public void displayFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        }
    }

    public void start() {
        while (true) {
            System.out.println("\nAirline Management System");
            System.out.println("1. Add Flight");
            System.out.println("2. Book Ticket");
            System.out.println("3. Display Flights");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addFlight();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    displayFlights();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        AirlineManagementSystem system = new AirlineManagementSystem();
        system.start();
    }
}
