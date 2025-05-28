import java.util.*;

public class RailwayEnquirySystem {
    static ArrayList<Train> trainList = new ArrayList<>();
    static ArrayList<Booking> bookingList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addSampleTrains();

        while (true) {
            System.out.println("\n--- Railway Enquiry System ---");
            System.out.println("1. View All Trains");
            System.out.println("2. Search Train by Source & Destination");
            System.out.println("3. Book Ticket");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    viewAllTrains();
                    break;
                case 2:
                    searchTrains(sc);
                    break;
                case 3:
                    bookTicket(sc);
                    break;
                case 4:
                    viewBookings();
                    break;
                case 5:
                    System.out.println("Thank you for using the Railway Enquiry System!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addSampleTrains() {
        trainList.add(new Train(101, "Express 1", "Hyderabad", "Delhi", "06:00"));
        trainList.add(new Train(102, "Superfast", "Chennai", "Mumbai", "08:30"));
        trainList.add(new Train(103, "Intercity", "Delhi", "Agra", "10:00"));
        trainList.add(new Train(104, "Local", "Hyderabad", "Warangal", "12:00"));
    }

    static void viewAllTrains() {
        System.out.println("\n--- Available Trains ---");
        for (Train train : trainList) {
            train.displayTrain();
        }
    }

    static void searchTrains(Scanner sc) {
        System.out.print("Enter Source: ");
        String source = sc.nextLine();
        System.out.print("Enter Destination: ");
        String dest = sc.nextLine();

        boolean found = false;
        System.out.println("\n--- Matching Trains ---");
        for (Train train : trainList) {
            if (train.source.equalsIgnoreCase(source) && train.destination.equalsIgnoreCase(dest)) {
                train.displayTrain();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No trains found for given route.");
        }
    }

    static void bookTicket(Scanner sc) {
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Train Number: ");
        int tNo = sc.nextInt();

        boolean valid = false;
        for (Train train : trainList) {
            if (train.trainNo == tNo) {
                bookingList.add(new Booking(name, tNo));
                System.out.println("Booking successful!");
                valid = true;
                break;
            }
        }
        if (!valid) {
            System.out.println("Invalid train number!");
        }
    }

    static void viewBookings() {
        System.out.println("\n--- Booked Tickets ---");
        for (Booking b : bookingList) {
            b.displayBooking();
        }
        if (bookingList.isEmpty()) {
            System.out.println("No bookings yet.");
        }
    }
}
