public class Main {
    public static void main(String[] args) {

        PublicTransport bus1 = new Bus(1);
        PublicTransport bus2 = new Bus(2);

        bus1.showStatus();
        bus1.chageVelocity(30);
        bus1.onBoard(2);
        bus1.showFuel();
        bus1.changeStatus();
        bus1.fillFuel(10);
        bus1.changeStatus();
        bus1.onBoard(45);
        bus1.offBoard(10);
        bus1.fillFuel(-45);
        bus1.chageVelocity(50);
        bus1.showStatus();
        System.out.println("-------bus>>>>>>>>taxi-----------");

        PublicTransport taxi1 = new Taxi(1);
        PublicTransport taxi2 = new Taxi(2);
        taxi1.showStatus();
        taxi1.onBoard(2);
        taxi1.fillFuel(-50);
        taxi1.offBoard(2);
        taxi1.onBoard(5);
        taxi1.onBoard(3);
        taxi1.fillFuel(-40);
        taxi1.offBoard(3);
        taxi1.showStatus();


    }
}