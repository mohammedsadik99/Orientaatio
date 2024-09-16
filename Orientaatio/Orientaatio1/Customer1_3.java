public class Customer1_3 {
    private static int idCounter = 1; // Static to keep track of ID for all customers
    private int id;                   // Unique ID for each customer
    private long startTime;            // Start time
    private long endTime;              // End time

    // Constructor to initialize a new Customer with the next ID and start time
    public Customer1_3(long startTime) {
        this.id = idCounter++;         // Assign current idCounter and increment
        this.startTime = startTime;
        this.endTime = 0;              // End time starts as 0 (unset)
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    // Method to calculate time spent (end time - start time)
    public long getTimeSpent() {
        return endTime - startTime;
    }
}
