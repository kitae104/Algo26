package inhatc.aic.algorithm.ch07;

import java.util.ArrayList;
import java.util.List;

public class BuggySubsetsNoRestore {

    static int[] numbers = {1, 2, 3};
    static List<Integer> chosen = new ArrayList<>();
    static int subsetCount = 0;

    static void subsets(int index) {
        if (index == numbers.length) {
            subsetCount++;
            System.out.println("부분집합 " + subsetCount + ": " + chosen);
            return;
        }

        chosen.add(numbers[index]);   // (1) 선택
        subsets(index + 1);           // (2) 진행
        // (3) 취소를 잊었다! chosen.remove(chosen.size() - 1)가 없다

        subsets(index + 1);           // 넣지 않는 경우
    }

    public static void main(String[] args) {
        System.out.println("{1, 2, 3}의 모든 부분집합:");
        subsets(0);
        System.out.println("총 " + subsetCount + "개 (기대값 8개)");
    }
}