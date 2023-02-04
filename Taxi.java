import java.util.Scanner;

public class Taxi extends PublicTransport {
    boolean isDrive = false;
    double defaultDistance = 1.6;
    double goalDistance = 0;
    int distanceFare = 2000;

    public Taxi(int id) {
        fare = 4800;
        maxPassenger = 4;
        setDefault(id);
    }

    @Override
    void showStatus() {
        String statusStr = "";
        if (status) {
            if (isDrive) statusStr = "운행중";
            else statusStr = "일반";
        } else statusStr = "운행중지";
        System.out.println("---현재 Taxi " + id + "상태---");
        System.out.println("현재 상태 :" + statusStr);
        System.out.println("현재 주유량 : " + fuel);
        System.out.println("현재 총 요금 : " + money + "원");
        System.out.println("----------------");
    }

    @Override
    void changeStatus() {
        status = !status;
        if (status) {
            if (fuel < 10) {
                System.out.println("연료부족! 주유량을 확인해 주세요.");
                status = false;
            } else {
                fuel -= 10;
                System.out.println("차량 상태가 [일반]으로 바뀝니다.");
            }
        } else {
            System.out.println("차량 상태가 [운행불가]로 바뀝니다.");
        }
    }

    @Override
    void onBoard(int newPeople) {
        if (!status) {
            System.out.println("운행불가 상태 입니다. 탑승할 수 없습니다.");
        } else {
            if (isDrive)
                System.out.println("운행중입니다. 탑승할 수 잆습니다.");
            else {
                if (newPeople > maxPassenger)
                    System.out.println("정원 초과입니다. 탑승할 수 없습니다.");
                else {
                    System.out.println("어서오세요.");
                    isDrive = true;
                    passenger = newPeople;
                    fuel -= newPeople;
                    getDistance();
                    System.out.println("운행을 시작합니다. 목적지 거리: " + goalDistance);
                }
            }
        }
    }

    void getDistance() {
        System.out.println("목적지 거리를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        goalDistance = scanner.nextDouble();
    }

    @Override
    void offBoard(int bye) {
        if (bye > passenger) {
            System.out.println("오류! 탑승객보다 내리는 인원이 큽니다.");
        } else {
            passenger -= bye;
            isDrive = false;
            int lastfare = (int) ((goalDistance - defaultDistance) * distanceFare + fare);
            System.out.println("요금은 " + lastfare + "원 입니다.");
            money += lastfare;
        }
    }
}
