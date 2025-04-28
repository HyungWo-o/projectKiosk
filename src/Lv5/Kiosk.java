package Lv5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // 생성자
    public Kiosk() {}

    // 기능
    public void start() {
        Scanner scanner = new Scanner(System.in);

        Menu menuCategory = new Menu();
        menuCategory.setCategory(new ArrayList<>());
        menuCategory.addCategory("Burgers");
        menuCategory.addCategory("Drinks");
        menuCategory.addCategory("Desserts");

        while (true) {
            // 반복문으로 돌아가며 카테고리 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menuCategory.getCategory().size(); i++) {
                System.out.println(i+1 + ". " + menuCategory.getCategory().get(i));
            }
            System.out.println("0. 종료");

            int num;
            try {
                num = scanner.nextInt();
                if (num == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println(menuCategory.getCategory().get(num - 1) + "를 선택하셨습니다.");
                    List<MenuItem> burgers = menuCategory.printMenu(num);

                    while (true) {
                        // 입력, 처리, 예외처리
                        try {
                            num = scanner.nextInt();
                            if (num == 0) {
                                System.out.println("카테고리 메뉴로 돌아갑니다.");
                                System.out.println();
                                break;
                            } else {
                                System.out.println("선택한 메뉴: " + burgers.get(num - 1).getName() + " | W " + burgers.get(num - 1).getPrice() + " | " + burgers.get(num - 1).getContent());
                            }
                        } catch (Exception e) {
                            System.out.println("메뉴에 해당하는 번호만 입력하십시오.");
                            scanner.nextLine();
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("메뉴에 해당하는 번호만 입력하십시오.");
                scanner.nextLine();
            }
        }
    }
}
