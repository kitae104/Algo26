package inhatc.aic.algorithm.ch07;

import java.util.ArrayList;
import java.util.List;

public class BuggyPermutationNoRestore {

    static char[] letters = {'a', 'b', 'c'};
    static boolean[] used = new boolean[letters.length];
    static StringBuilder current = new StringBuilder();
    static int permCount = 0;

    static void permutation() {
        if (current.length() == letters.length) {
            permCount++;
            System.out.println("순열 " + permCount + ": " + current);
            return;
        }

        for (int i = 0; i < letters.length; i++) {
            if (used[i]) continue;
            used[i] = true;                                // (1) 선택
            current.append(letters[i]);
            permutation();                                 // (2) 진행
            current.deleteCharAt(current.length() - 1); // (3) 취소: current 복원
           // used[i] = false;                               //          used 복원
        }
    }

    public static void main(String[] args) {
        System.out.println("{a, b, c}의 모든 순열:");
        permutation();
        System.out.println("총 " + permCount + "개 (기대값 6개)");
    }
}