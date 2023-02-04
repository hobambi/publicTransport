import java.util.HashSet;

public abstract class PublicTransport {
    int id; // 번호 (고유값)
    HashSet<Integer> idContains = new HashSet<Integer>();
    int fuel = 100; // 주유량
    int maxFuel = 100; // 최대 주유량
    int velocity = 0; // 현재 속도
    int maxPassenger; // 최대 승객 수
    int passenger = 0; // 현재 승객 수
    boolean isDrive; // 상태 (운행중, 차고지행)
    int fare; // 기본 요금
    int money = 0;

    void setDefault(int id) { //기본 세팅
        if (idContains.contains(id)) {
            System.out.println("이미 있는 번호 입니다. 번호를 다시 확인하세요.");
        } else {
            this.id = id;
            idContains.add(id);
            fuel = 100;
            velocity = 0;
            isDrive = true;
            System.out.println(id + "번 버스 시작합니다.");
        }
    }

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

    void showStatus(){
        System.out.println("----현재 상태----");
        System.out.println("현재 탑승객 : "+ passenger +"명");
        System.out.println("잔여 승객수 : " + (maxPassenger-passenger)+"명");
        System.out.println("현재 주유량 : " + fuel);
        System.out.println("현재 총 요금 : " + money + "원");
        System.out.println("----------------");
    }

    void changeStatus() {
        isDrive = !isDrive;
        if (isDrive) {
            if (fuel < 10) {
                System.out.println("연료부족! 주유량을 확인해 주세요.");
                isDrive = false;
            } else {
                fuel -= 10;
                System.out.println("차량 상태가 [운행중]으로 바뀝니다.");
            }
        } else {
            System.out.println("차량 상태가 [차고지행]으로 바뀝니다.");
        }
    }

    void onBoard(int newPeople) {
        if (isDrive) {
            for (int i = 0; i < newPeople; i++) {
                if (passenger + 1 > maxPassenger) {
                    System.out.println("정원 초과입니다. 더이상 탈 수 없습니다.");
                    break;
                } else {
                    passenger += 1;
                    money += fare;
                    fuel -= 1;
                }
            }
            System.out.println("탑승 승객 수는 " + passenger + "명 입니다.");
            System.out.println("잔여 승객 수는 " + (maxPassenger - passenger) + "명 입니다.");

        } else {
            System.out.println("차량이 운행중이 아닙니다. 승객이 탈 수 없습니다.");
        }
    }

    void offBoard(int bye){
        if(bye>passenger){
            System.out.println("오류! 탑승객보다 내리는 인원이 큽니다.");
        }else {
            System.out.println("안녕히가세요!");
            passenger -= bye;
            System.out.println("탑승 승객 수는 " + passenger + "명 입니다.");
        }
    }

    void showFuel() {
        System.out.println("현재 주유량은 " + fuel + "입니다.");
    }

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
