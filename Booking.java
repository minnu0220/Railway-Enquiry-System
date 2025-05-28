public class Booking {
    String passengerName;
    int trainNo;

    public Booking(String passengerName, int trainNo) {
        this.passengerName = passengerName;
        this.trainNo = trainNo;
    }

    public void displayBooking() {
        System.out.println("Passenger: " + passengerName + " | Train No: " + trainNo);
    }
}
