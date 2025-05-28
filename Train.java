public class Train {
    int trainNo;
    String trainName;
    String source;
    String destination;
    String departureTime;

    public Train(int trainNo, String trainName, String source, String destination, String departureTime) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public void displayTrain() {
        System.out.println(trainNo + " - " + trainName + " | From: " + source + " | To: " + destination + " | Departs at: " + departureTime);
    }
}
