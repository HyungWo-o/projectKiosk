package Lv7;

public enum Discount {
    NATIONAL_MERIT("국가유공자",0.1),
    SOLDIER("군인",0.05),
    STUDENT("학생", 0.03),
    GENERAL("일반", 0.0);

    private double dcRate;
    private String name;

    Discount(String name, double dcRate) {
        this.dcRate = dcRate;
        this.name = name;
    }

    public void printDc() {
        System.out.println("할인 정보를 입력해주세요.");
        Discount[] dcArr = Discount.values();
        for (Discount val : dcArr) {
            System.out.println((val.ordinal()+1) + ". " + val.name + " : " + (int)(val.dcRate * 100) + "%");
        }
    }

    public double selectDc(int num) {
        Discount[] dcArr = Discount.values();
        if (num < dcArr.length) {
            Discount dcType = dcArr[num-1];
            return (1 - dcType.dcRate);
        } else {
            return -1;
        }
    }

}
