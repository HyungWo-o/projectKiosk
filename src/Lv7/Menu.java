package Lv7;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    // 속성
    private List<MenuItem> menuItem;
    private List<String> category;

    // 생성자

    public Menu() {}

    // 기능
    public List<MenuItem> getMenuItem() {
        return menuItem;
    }

    public void setMenuITem(List<MenuItem> menuItem) { this.menuItem = menuItem; }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItem.add(menuItem);
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) { this.category = category; }

    public void addCategory(String category) {
        this.category.add(category);
    }

    public List<MenuItem> printMenu(int num) {

        Menu menu = new Menu();
        menu.setMenuITem(new ArrayList<>());

        MenuItem item1 = new MenuItem();
        MenuItem item2 = new MenuItem();
        MenuItem item3 = new MenuItem();
        MenuItem item4 = new MenuItem();

        // 객체에 이름, 가격, 설명 넣고 리스트에 넣기
        if(num == 1) {

            item1.setName("ShackBurger");
            item1.setPrice(6.9);
            item1.setContent("토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            menu.addMenuItem(item1);

            item2.setName("SmokeShack");
            item2.setPrice(8.9);
            item2.setContent("베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            menu.addMenuItem(item2);

            item3.setName("Cheeseburger");
            item3.setPrice(6.9);
            item3.setContent("포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            menu.addMenuItem(item3);

            item4.setName("Hamburger");
            item4.setPrice(5.4);
            item4.setContent("비프패티를 기반으로 야채가 들어간 기본버거");
            menu.addMenuItem(item4);

        } else if (num == 2) {

            item1.setName("Coke");
            item1.setPrice(2.0);
            item1.setContent("탄산의 zl존 오zlzl날 콜라");
            menu.addMenuItem(item1);

            item2.setName("Cider");
            item2.setPrice(2.0);
            item2.setContent("급하게 먹어도 cider면 괜찮아");
            menu.addMenuItem(item2);

            item3.setName("Zero Coke");
            item3.setPrice(2.5);
            item3.setContent("제로콜라를 먹으면 0칼로리");
            menu.addMenuItem(item3);

            item4.setName("Zero Cider");
            item4.setPrice(2.5);
            item4.setContent("제로사이다를 먹으면 0칼로리");
            menu.addMenuItem(item4);

        } else {
            item1.setName("Fried Potato");
            item1.setPrice(3.0);
            item1.setContent("감자튀김은 세상을 지배하지");
            menu.addMenuItem(item1);

            item2.setName("Cheese Potato");
            item2.setPrice(4.0);
            item2.setContent("감자튀김에 치즈는 못참지");
            menu.addMenuItem(item2);

        }

        // 반복문으로 돌아가며 메뉴 출력
        int i = 0;
        for (MenuItem menuItem : menu.getMenuItem()) {
            // 메뉴명 뒤에 공백 넣어 출력문을 보기 좋게 정렬하기
            while (true) {
                if (menuItem.getName().length() < 15)
                    menuItem.setName(menuItem.getName() + " ");
                else
                    break;
            }

            // 메뉴 출력
            System.out.println(++i + ". " + menuItem.getName() + " | W " + menuItem.getPrice() + " | " + menuItem.getContent());
        }
        System.out.println("0. 카테고리 메뉴로 돌아가기");

        return menu.getMenuItem();
    }
}
