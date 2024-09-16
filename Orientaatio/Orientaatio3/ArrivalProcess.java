import java.util.PriorityQueue;
import java.util.Random;

public class ArrivalProcess {
    private static final double LAMBDA = 1.0;  // Rate parameter for Exponential distribution
    private Random random;
    private long currentTime;
    private PriorityQueue<Event> eventQueue;

    // Constructor
    public ArrivalProcess(PriorityQueue<Event> eventQueue) {
        this.random = new Random();
        this.currentTime = 0;
        this.eventQueue = eventQueue;
    }

    // Method to generate the next arrival event
    public void generateNextArrival() {
        // Generate the time until the next arrival using Exponential distribution
        double interval = -Math.log(1.0 - random.nextDouble()) / LAMBDA;
        long nextArrivalTime = (long) (currentTime + interval);

        // Create the arrival event
        Event arrivalEvent = new Event(nextArrivalTime, EventType.ARRIVAL);

        // Add the event to the event queue
        eventQueue.add(arrivalEvent);

        // Update the current time for the next interval
        currentTime = nextArrivalTime;
    }
}
