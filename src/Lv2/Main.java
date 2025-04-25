package Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menuItems = new ArrayList<>();

        MenuItem item1 = new MenuItem();
        MenuItem item2 = new MenuItem();
        MenuItem item3 = new MenuItem();
        MenuItem item4 = new MenuItem();

        // 객체에 이름, 가격, 설명 넣고 리스트에 넣기
        item1.setName("ShackBurger");
        item1.setPrice(6.9);
        item1.setContent("토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuItems.add(item1);

        item2.setName("SmokeShack");
        item2.setPrice(8.9);
        item2.setContent("베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menuItems.add(item2);

        item3.setName("Cheeseburger");
        item3.setPrice(6.9);
        item3.setContent("포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuItems.add(item3);

        item4.setName("Hamburger");
        item4.setPrice(5.4);
        item4.setContent("비프패티를 기반으로 야채가 들어간 기본버거");
        menuItems.add(item4);

        System.out.println("[ SHAKESHACK MENU ]");

        // 반복문으로 돌아가며 메뉴 출력
        for (int i = 0; i < menuItems.stream().count(); i++) {

            // 메뉴명 뒤에 공백 넣어 출력문 보기 좋게 정렬하기
            String itemName = menuItems.get(i).getName();
            while (true) {
                if (itemName.length() < 15)
                    itemName = itemName + " ";
                else
                    break;
            }

            System.out.println(i+1 + ". " + itemName + " | W " + menuItems.get(i).getPrice() + " | " + menuItems.get(i).getContent());
        }
        System.out.println("0. 종료      | 종료");

        int num = scanner.nextInt();
        if(num == 0) {
            System.out.println("프로그램을 종료합니다.");
        }

    }
}
