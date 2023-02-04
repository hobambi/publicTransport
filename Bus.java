public class Bus extends PublicTransport {


    public Bus(int id) {
        fare = 1500;
        maxPassenger = 40;
        setDefault(id);
    }

    @Override
    void showStatus() {
        System.out.println("---현재 Bus " + id + "상태---");
        System.out.println("현재 탑승객 : " + passenger + "명");
        System.out.println("잔여 승객수 : " + (maxPassenger - passenger) + "명");
        System.out.println("현재 주유량 : " + fuel);
        System.out.println("현재 총 요금 : " + money + "원");
        System.out.println("----------------");
    }

    @Override
    void onBoard(int newPeople) {
        if (status) {
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

    @Override
    void changeStatus() {
        status = !status;
        if (status) {
            if (fuel < 10) {
                System.out.println("연료부족! 주유량을 확인해 주세요.");
                status = false;
            } else {
                fuel -= 10;
                System.out.println("차량 상태가 [운행중]으로 바뀝니다.");
            }
        } else {
            System.out.println("차량 상태가 [차고지행]으로 바뀝니다.");
        }
    }

    void offBoard(int bye) {
        if (bye > passenger) {
            System.out.println("오류! 탑승객보다 내리는 인원이 큽니다.");
        } else {
            System.out.println("안녕히가세요!");
            passenger -= bye;
            System.out.println("탑승 승객 수는 " + passenger + "명 입니다.");
        }
    }


}
