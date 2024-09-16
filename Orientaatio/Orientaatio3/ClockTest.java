// ClockTest.java
public class ClockTest {
    public static void main(String[] args) {
        // Get the singleton instance of Clock
        Clock clock = Clock.getInstance();

        // Display the initial time
        System.out.println("Initial Time: " + clock.getTime());

        // Set and display a new time
        clock.setTime(1234567890L);
        System.out.println("Updated Time: " + clock.getTime());

        // Demonstrate singleton behavior
        Clock anotherClock = Clock.getInstance();
        System.out.println("Time from another instance: " + anotherClock.getTime());

        // Set a new time via the second reference
        anotherClock.setTime(9876543210L);
        System.out.println("Updated Time from original instance: " + clock.getTime());
    }
}