package spring.report.report1;

class Main {
    public static void main(String[] args) {


        Vehicle myBus1 = new Vehicle(30, 1000, 100);
        Vehicle myBus2 = new Vehicle(30, 1000, 100);

        myBus1.busStatus();
        myBus2.busStatus();
        myBus1.addPassenger(10);
        myBus1.useFuel(-50);
        myBus1.changeStatus();
        myBus1.useFuel(10);
        myBus1.changeStatus();
        myBus1.addPassenger(45);
        myBus1.addPassenger(5);
        myBus1.useFuel(-55);
    }
}
