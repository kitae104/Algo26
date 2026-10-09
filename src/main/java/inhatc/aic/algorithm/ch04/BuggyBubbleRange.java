package inhatc.aic.algorithm.ch04;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BuggyBubbleRange {
    public static void main(String[] args) {
        int[] prices = {26, 15, 38, 12, 21};

        // 버블 정렬 — 이웃한 두 값을 비교하려고 한다
        for (int i = 0; i < prices.length - 1; i++) {
            // 잘못된 범위: j가 마지막 칸까지 가면 j + 1은 배열 밖이다
            for (int j = 0; j < prices.length - i - 1; j++) {
                if (prices[j] > prices[j + 1]) {
                    int temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;
                }
            }
        }

        System.out.println("정렬 완료" + Arrays.toString(prices));
        IntStream.of(prices).forEach((x) -> System.out.print(x + " "));
    }
}