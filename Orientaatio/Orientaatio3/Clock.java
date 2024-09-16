// Clock.java
public class Clock {
    private static Clock instance;  // Singleton instance
    private long currentTime;        // Time in milliseconds

    // Private constructor to prevent instantiation
    private Clock() {
        this.currentTime = 0;  // Initialize time
    }

    // Public method to provide access to the singleton instance
    public static synchronized Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    // Method to set the current time
    public void setTime(long time) {
        this.currentTime = time;
    }

    // Method to get the current time
    public long getTime() {
        return this.currentTime;
    }
}
