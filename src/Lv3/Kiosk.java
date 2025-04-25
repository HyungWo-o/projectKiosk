package Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // 속성
    private List<MenuItem> menuItems;

    // 생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    };

    // 기능
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void start(Kiosk kiosk) {

        MenuItem item1 = new MenuItem();
        MenuItem item2 = new MenuItem();
        MenuItem item3 = new MenuItem();
        MenuItem item4 = new MenuItem();

        // 객체에 이름, 가격, 설명 넣고 리스트에 넣기
        item1.setName("ShackBurger");
        item1.setPrice(6.9);
        item1.setContent("토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        kiosk.addMenuItem(item1);

        item2.setName("SmokeShack");
        item2.setPrice(8.9);
        item2.setContent("베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        kiosk.addMenuItem(item2);

        item3.setName("Cheeseburger");
        item3.setPrice(6.9);
        item3.setContent("포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        kiosk.addMenuItem(item3);

        item4.setName("Hamburger");
        item4.setPrice(5.4);
        item4.setContent("비프패티를 기반으로 야채가 들어간 기본버거");
        kiosk.addMenuItem(item4);

        System.out.println("[ SHAKESHACK MENU ]");

        // 반복문으로 돌아가며 메뉴 출력
        for (int i = 0; i < kiosk.getMenuItems().stream().count(); i++) {

            String itemName = kiosk.getMenuItems().get(i).getName();
            double itemPrice = kiosk.getMenuItems().get(i).getPrice();
            String itemContent = kiosk.getMenuItems().get(i).getContent();

            // 메뉴명 뒤에 공백 넣어 출력문을 보기 좋게 정렬하기
            while (true) {
                if (itemName.length() < 15)
                    itemName = itemName + " ";
                else
                    break;
            }

            // 메뉴 출력
            System.out.println(i+1 + ". " + itemName + " | W " + itemPrice + " | " + itemContent);
        }
        System.out.println("0. 종료");

        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            // 입력, 처리, 예외처리
            try {
                num = scanner.nextInt();
                if(num == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println(kiosk.getMenuItems().get(num-1).getName() + "가 추가되었습니다.");
                }
            } catch (Exception e) {
                System.out.println("메뉴에 해당하는 번호만 입력하십시오.");
                scanner.nextLine();
            }
        }

    }
}
