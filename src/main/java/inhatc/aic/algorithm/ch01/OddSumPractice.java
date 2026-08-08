package inhatc.aic.algorithm.ch01;

public class OddSumPractice {

    /** 방법 A: 1부터 n까지의 홀수를 반복문으로 더한다. */
    static long oddSumByLoop(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                sum = sum + i;
            }
        }
        return sum;
    }

    /** 방법 B: 1부터 n까지 홀수의 개수를 k라 하면, 홀수의 합은 k * k 이다. */
    static long oddSumByFormula(int n) {
        long k = (n + 1) / 2;   // 1부터 n까지 홀수의 개수
        return k * k;
    }

    public static void main(String[] args) {
        int[] tests = {1, 7, 8, 100};
        for (int n : tests) {
            long a = oddSumByLoop(n);
            long b = oddSumByFormula(n);
            System.out.println("n=" + n + " : 반복문 " + a + ", 공식 " + b
                    + ", 일치 = " + (a == b));
        }
    }
}
