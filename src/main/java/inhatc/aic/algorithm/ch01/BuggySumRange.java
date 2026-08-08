package inhatc.aic.algorithm.ch01;

public class BuggySumRange {
    public static void main(String[] args) {
        int n = 8;
        long sum = 0;

        // 1부터 n까지의 합을 구하고 싶다
        for (int i = 1; i < n; i++) {
            sum = sum + i;
        }

        System.out.println("1부터 " + n + "까지의 합 = " + sum);
    }
}