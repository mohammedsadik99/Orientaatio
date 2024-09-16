public class CustomerGenerator {
    private ServicePoint ServicePoint;

    public CustomerGenerator(ServicePoint servicePoint) {
        this.ServicePoint = servicePoint;
    }

    // Create and add a specified number of customers to the service point's queue
    public void generateCustomers(int numberOfCustomers) {
        for (int i = 0; i < numberOfCustomers; i++) {
            // Create a new customer with the current time as start time
            Customer1_4 customer = new Customer1_4(System.nanoTime());
            ServicePoint.addToQueue(customer);
        }
    }
}
