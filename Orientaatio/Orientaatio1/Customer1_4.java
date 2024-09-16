public class Customer1_4 {
    private static int idCounter = 1;
    private int id;
    private long startTime;
    private long endTime;

    public Customer1_4(long startTime) {
        this.id = idCounter++;
        this.startTime = startTime;
        this.endTime = 0;
    }

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

    public long getTimeSpent() {
        return endTime - startTime;
    }
}
