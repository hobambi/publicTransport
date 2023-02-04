import java.util.HashSet;

public abstract class PublicTransport {
    int id; // 번호 (고유값)
    HashSet<Integer> idContains = new HashSet<Integer>();
    int fuel = 100; // 주유량
    int maxFuel = 100; // 최대 주유량
    int velocity = 0; // 현재 속도
    int maxPassenger; // 최대 승객 수
    int passenger = 0; // 현재 승객 수
    boolean status; // 상태 (true = 운행중)
    int fare; // 기본 요금
    int money = 0;

    // 기본 상태 세팅
    void setDefault(int id) {
        if (this.idContains.contains(id)) {
            System.out.println("이미 있는 번호 입니다. 번호를 다시 확인하세요.");
        } else {
            this.id = id;
            this.idContains.add(id);
            fuel = 100;
            velocity = 0;
            status = true;
        }
    }

    // 속도 바꾸기
    void chageVelocity(int changeVelocity) {
        if (fuel < 10) {
            System.out.println("연료부족! 주유량을 확인해 주세요!");
        } else {
            velocity += changeVelocity;
            if (velocity < 0) {
                fuel -= 10;
                System.out.println("후진합니다.");
            } else if (velocity == 0) {
                System.out.println("차량이 정지 합니다.");
            } else {
                fuel -= 10;
                System.out.println("속도가 바뀌었습니다. 현재 속도 :" + velocity);
            }

        }
    }

    // 현재 상태 보여주기
    abstract void showStatus();

    // 상태 바꾸기 (버스와 택시가 달라 추상메서드)
    abstract void changeStatus();

    // 승객 탑승
    abstract void onBoard(int newPeople);

    // 승객 내리기
    abstract void offBoard(int bye);

    // 현재 주유량 보여주기
    void showFuel() {
        System.out.println("현재 주유량은 " + fuel + "입니다.");
    }

    // 주유하기 or 소비하기
    void fillFuel(int fill) {
        if (fill + fuel > maxFuel) {
            System.out.println("최대 주유량을 초과하였습니다.");
            System.out.println("잔여 주유량 :" + (maxFuel - fuel));
        }else if(fill+fuel<10){
            fuel += fill;
            System.out.println("주유가 필요합니다!");
            System.out.println("현재 주유량 :" + fuel);
        }else {
            fuel += fill;
            System.out.println("현재 주유량 :" + fuel);
        }
    }

}
