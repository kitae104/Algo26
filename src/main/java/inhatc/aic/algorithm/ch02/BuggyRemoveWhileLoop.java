package inhatc.aic.algorithm.ch02;

import java.util.ArrayList;

public class BuggyRemoveWhileLoop {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(55);
        scores.add(58);
        scores.add(90);
        scores.add(45);
        scores.add(47);

        // 60점 미만인 점수를 모두 삭제하고 싶다
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) < 60) {
                scores.remove(i); // i--; // 삭제 후 인덱스를 조정하지 않아 문제가 발생
            }
        }

        System.out.println("남은 점수: " + scores);
    }
}