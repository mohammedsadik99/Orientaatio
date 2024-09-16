import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer1_4> queue;
    private long totalServiceTime; // Total service time of all customers
    private int servedCustomerCount; // Count of served customers

    public ServicePoint() {
        queue = new LinkedList<>();
        totalServiceTime = 0;
        servedCustomerCount = 0;
    }

    // Add customer to the queue
    public void addToQueue(Customer1_4 customer) {
        queue.addFirst(customer); // Add customer to the beginning of the queue
        System.out.println("Customer " + customer.getId() + " added to the queue.");
    }

    // Remove customer from the queue
    public Customer1_4 removeFromQueue() {
        return queue.removeLast(); // FIFO - Remove the last customer
    }

    // Serve the customers in the queue
    public void serve() throws InterruptedException {
        while (!queue.isEmpty()) {
            // Remove the customer from the queue (FIFO)
            Customer1_4 currentCustomer = removeFromQueue();
            long currentTime = System.nanoTime();

            // Simulate service time with a random delay between 500ms and 2000ms
            long serviceTime = (long)(Math.random() * 1500) + 500;
            Thread.sleep(serviceTime);  // Simulate service

            // Set end time as the current time after service
            currentCustomer.setEndTime(System.nanoTime());

            // Calculate response time: waiting time + service time
            long responseTime = currentCustomer.getEndTime() - currentCustomer.getStartTime();

            // Add service time to total service time
            totalServiceTime += serviceTime;
            servedCustomerCount++;

            // Print service information for the customer
            System.out.println("Customer " + currentCustomer.getId() + " served.");
            System.out.println("Response time: " + responseTime / 1_000_000 + " milliseconds");
            System.out.println("Service time: " + serviceTime + " milliseconds\n");
        }

        // Calculate and print average service time
        if (servedCustomerCount > 0) {
            double averageServiceTime = (double) totalServiceTime / servedCustomerCount;
            System.out.println("Average service time: " + averageServiceTime + " milliseconds");
        } else {
            System.out.println("No customers were served.");
        }
    }
}
