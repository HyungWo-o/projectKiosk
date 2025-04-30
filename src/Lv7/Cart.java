package Lv7;

import java.util.List;
import java.util.Scanner;


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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double Order(List<Cart> cart) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");

        double totalPrice = 0.0;
        int i = 0;
        for (Cart c : cart) {
            // 메뉴명 뒤에 공백 넣어 출력문을 보기 좋게 정렬하기
            while (true) {
                if (c.getMenuItem().getName().length() < 15)
                    c.getMenuItem().setName(c.getMenuItem().getName() + " ");
                else
                    break;
            }
            System.out.println(++i + ". " + c.getMenuItem().getName() + " | W " + c.getMenuItem().getPrice() + " | " + c.getMenuItem().getContent() + " | " + c.getQuantity());
            totalPrice += c.getMenuItem().getPrice() * c.getQuantity();
        }
        totalPrice = Math.round(totalPrice * 1000) / 1000.00;
        System.out.println("[ Total ]");
        System.out.println("W " + totalPrice);
        System.out.println();
        System.out.println("1. 주문      2. 메뉴 수정      3.메뉴판");
        return totalPrice;
    }

    public void updateCart(List<Cart> cart, int num) {
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        for (Cart c : cart) {
            if (num == i) {
                System.out.println(c.getMenuItem().getName() + " 메뉴의 원하시는 수량을 입력해주세요.");
                System.out.println("'0'을 입력하시면 메뉴가 삭제됩니다.");
                System.out.println("음수를 입력하시면 이전 메뉴로 돌아갑니다.");
                try {
                    int num2 = scanner.nextInt();
                    if (num2 == 0) {
                        cart.remove(c);
                        System.out.println("삭제되었습니다.");
                    } else if (num2 > 0) {
                        c.setQuantity(num2);
                        System.out.println("수정되었습니다.");
                    }
                } catch (Exception e) {
                    System.out.println("오입력으로 이전 메뉴로 돌아갑니다.");
                    scanner.nextLine();
                }
                System.out.println();
                break;
            }
            i++;
        }


    }
}
