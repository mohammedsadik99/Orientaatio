public class Event implements Comparable<Event> {
    private long eventTime;
    private EventType eventType;
    private String description; // Optional, for better readability

    public Event(long eventTime, EventType eventType, String description) {
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.description = description;
    }

    public long getEventTime() {
        return eventTime;
    }

    public void setEventTime(long eventTime) {
        this.eventTime = eventTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Event other) {
        return Long.compare(this.eventTime, other.eventTime);
    }

    @Override
    public String toString() {
        return "Event{time=" + eventTime + ", type=" + eventType + ", description='" + description + "'}";
    }
}
