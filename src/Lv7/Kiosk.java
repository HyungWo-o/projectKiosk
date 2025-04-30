package Lv7;

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

        Cart order = new Cart();
        List<Cart> cart = new ArrayList<>();

        while (true) {
            // 반복문으로 돌아가며 카테고리 출력
            int num = 0;
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menuCategory.getCategory().size(); i++) {
                System.out.println(i+1 + ". " + menuCategory.getCategory().get(i));
                if(i == menuCategory.getCategory().size() - 1) {
                    System.out.println("0. 종료");
                    System.out.println();
                    // 장바구니에 담겼을 때만 출력
                    if(!cart.isEmpty()) {
                        System.out.println("[ ORDER MENU ]");
                        System.out.println(i+2 + ". Orders     | 장바구니를 확인 후 주문합니다.");
                        System.out.println(i+3 + ". Cancel     | 진행중인 주문을 취소합니다.");
                        num = i + 2;
                    }
                }
            }

            int num1;
            int num4;
            try {
                num1 = scanner.nextInt();
                if (num1 == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (num1 == num) {
                    // Orders 선택
                    double totalPrice = order.Order(cart);
                    try {
                        num4 = scanner.nextInt();
                        if (num4 == 1) {
                            Discount.GENERAL.printDc();
                            int num5;
                            double dc;
                            try {
                                num5 = scanner.nextInt();
                                dc = Discount.GENERAL.selectDc(num5);
                                if (dc == -1)
                                    throw new Exception();

                                totalPrice = Math.round(totalPrice * dc * 1000) / 1000.00;
                                System.out.println("주문이 완료되었습니다. 금액은 W " + totalPrice + "입니다.");
                                System.out.println();
                                cart = new ArrayList<>();

                            } catch (Exception e) {
                                System.out.println("메뉴에 해당하는 번호만 입력하십시오. 오입력으로 인해 처음으로 돌아갑니다.");
                                scanner.nextLine();
                            }
                        } else if (num4 == 2) {
                            // 장바구니 메뉴 수정
                            System.out.println("메뉴 수정을 선택하셨습니다.");
                            System.out.println("장바구니에서 수정하려는 메뉴 번호를 입력해주세요.");
                            int num6;
                            try {
                                num6 = scanner.nextInt();
                                // 장바구니 메뉴 수정 로직
                                order.updateCart(cart, num6);

                            } catch (Exception e) {
                                System.out.println("메뉴에 해당하는 번호만 입력하십시오. 오입력으로 인해 처음으로 돌아갑니다.");
                                scanner.nextLine();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("메뉴에 해당하는 번호만 입력하십시오. 오입력으로 인해 처음으로 돌아갑니다.");
                        scanner.nextLine();
                    }
                } else {
                    System.out.println(menuCategory.getCategory().get(num1 - 1) + "를 선택하셨습니다.");
                    System.out.println();
                    System.out.println("[ " + menuCategory.getCategory().get(num1 - 1).toUpperCase() + " MENU");
                    List<MenuItem> menus = menuCategory.printMenu(num1);

                    int num2;
                    String selectedMenuName;
                    double selectedMenuPrice;
                    String selectedMenuContent;
                    while (true) {
                        // 입력, 처리, 예외처리
                        try {
                            num2 = scanner.nextInt();
                            if (num2 == 0) {
                                System.out.println("이전 메뉴로 돌아갑니다.");
                                System.out.println();
                                break;
                            } else {
                                selectedMenuName = menus.get(num2 - 1).getName();
                                selectedMenuPrice = menus.get(num2 - 1).getPrice();
                                selectedMenuContent = menus.get(num2 - 1).getContent();
                                System.out.println("선택한 메뉴: " + selectedMenuName + " | W " + selectedMenuPrice + " | " + selectedMenuContent);
                                System.out.println("위 메뉴를 장바구니에 추가하시려면 수량을 입력해주세요.");
                                System.out.println("취소하시려면 '0'을 입력해주세요.");

                                int num3;
                                boolean flg = false;
                                try {
                                    num3 = scanner.nextInt();
                                    if (num3 == 0) {
                                        System.out.println("이전 메뉴로 돌아갑니다.");
                                        System.out.println();
                                        break;
                                    } else {
                                        System.out.println(selectedMenuName + " " + num3 + "개가 장바구니에 추가되었습니다.");
                                        // 장바구니에 추가 로직
                                        // 카트에 이미 담긴 상품은 수량만 수정
                                        for (Cart c : cart) {
                                            if (selectedMenuName.equals(c.getMenuItem().getName())) {
                                                c.addQuantity(num3);
                                                flg = true;
                                                break;
                                            }
                                        }
                                        // 카트에 안담겨있는 상품은 새로 추가
                                        if (!flg) {
                                            cart.add(new Cart(menus.get(num2 - 1), num3));
                                        }
                                        System.out.println("더 주문하시려면 메뉴의 숫지를, 이전으로 돌아가시려면 '0'을 입력하세요.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("메뉴에 해당하는 번호만 입력하십시오.");
                                    scanner.nextLine();
                                }
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
