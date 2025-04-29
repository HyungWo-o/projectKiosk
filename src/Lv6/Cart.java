package Lv6;

import java.util.List;

public class Cart {

    // 속성
    private MenuItem menuItem;
    private int quantity;

    // 생성자
    public Cart() {}

    public Cart(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    // 기능
    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double Order(List<Cart> cart) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");

        double totalPrice = 0.0;
        for (Cart c : cart.stream().toList()) {
            // 메뉴명 뒤에 공백 넣어 출력문을 보기 좋게 정렬하기
            while (true) {
                if (c.getMenuItem().getName().length() < 15)
                    c.getMenuItem().setName(c.getMenuItem().getName() + " ");
                else
                    break;
            }
            System.out.println(c.getMenuItem().getName() + " | W " + c.getMenuItem().getPrice() + " | " + c.getMenuItem().getContent() + " | " + c.getQuantity());
            totalPrice += c.getMenuItem().getPrice() * c.getQuantity();
        }

        System.out.println("[ Total ]");
        System.out.println("W " + totalPrice);
        System.out.println();
        System.out.println("1. 주문      2. 메뉴판");
        return totalPrice;
    }
}
