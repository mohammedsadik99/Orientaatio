import java.util.PriorityQueue;

public class EventList {
    private PriorityQueue<Event> eventQueue;

    public EventList() {
        eventQueue = new PriorityQueue<>();
    }

    public void addEvent(Event event) {
        eventQueue.add(event);
    }

    public Event getNextEvent() {
        return eventQueue.poll(); // Retrieves and removes the head of the queue
    }

    public void printEvents() {
        PriorityQueue<Event> tempQueue = new PriorityQueue<>(eventQueue); // Copy for iteration
        while (!tempQueue.isEmpty()) {
            System.out.println(tempQueue.poll());
        }
    }
}
