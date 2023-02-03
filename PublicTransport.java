import java.util.HashSet;

public abstract class PublicTransport {
    int id; // 번호 (고유값)
    HashSet<Integer> idContains = new HashSet<Integer>();
    int fuel; // 주유량
    int velocity; // 현재 속도
    int changeVelocity; // 변경 속도
    int maxPassenger; // 최대 승객 수
    int passenger; // 현재 승객 수
    boolean isDrive; // 상태 (운행중, 차고지행)

    void setDefault(int id) { //기본 세팅

        if (idContains.contains(id)) {
            System.out.println("이미 있는 번호 입니다. 번호를 다시 확인하세요.");
        } else {
            this.id = id;
            idContains.add(id);
            fuel = 100;
            velocity = 0;
            isDrive = true;
            System.out.println(id+"번 버스 시작합니다.");
        }
    }

}
