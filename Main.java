public class Main {
    public static void main(String[] args) {

        Bus bus1 = new Bus(1);
        Bus bus2 = new Bus(2);

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


    }
}