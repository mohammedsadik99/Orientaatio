public class CustomerQueueTest1_4 {
    public static void main(String[] args) throws InterruptedException {

        ServicePoint servicePoint = new ServicePoint();

        CustomerGenerator generator = new CustomerGenerator(servicePoint);
        generator.generateCustomers(5);

        servicePoint.serve();
    }
}
