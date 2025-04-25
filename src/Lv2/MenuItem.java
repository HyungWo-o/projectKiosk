package Lv2;

public class MenuItem {

    // 속성
    private String name;
    private double price;
    private String content;

    // 생성자
    public MenuItem() {}

    // 기능 (getter, setter)
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
