public class EventTest {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // Add events to the list
        eventList.addEvent(new Event(1000, EventType.ARRIVAL, "Customer arrives"));
        eventList.addEvent(new Event(500, EventType.EXIT, "Customer exits"));
        eventList.addEvent(new Event(1500, EventType.ARRIVAL, "Another customer arrives"));

        // Print the contents of the EventList, ordered by event time
        System.out.println("Events in order:");
        eventList.printEvents();

        // Remove the first event and print it
        Event nextEvent = eventList.getNextEvent();
        System.out.println("\nNext event to be processed:");
        System.out.println(nextEvent);
    }
}
