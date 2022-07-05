package hello.core.singleton;
public class StatefulService {
    private int price; //상태를 유지하는 필드
    // 반환값을 int price로 해 지역변수로만 사용하게 해서 해결할 수 있다.
    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //여기가 문제!
        // return price;
    }
    public int getPrice() {
        return price;
    }
}