package Lv3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Kiosk kiosk = new Kiosk(new ArrayList<>());

        // 키오스크 시작
        kiosk.start(kiosk);

    }
}
