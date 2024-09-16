import java.util.PriorityQueue;

public class ArrivalProcessTest {
    public static void main(String[] args) {
        // Define the event queue
        PriorityQueue<Event> eventQueue = new PriorityQueue<>();

        // Create the ArrivalProcess
        ArrivalProcess arrivalProcess = new ArrivalProcess(eventQueue);

        // Generate some arrival events
        for (int i = 0; i < 10; i++) {
            arrivalProcess.generateNextArrival();
        }

        // Print events in the queue
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            System.out.println("Event at time " + event.getTime() + ": " + event.getType());
        }
    }
}
