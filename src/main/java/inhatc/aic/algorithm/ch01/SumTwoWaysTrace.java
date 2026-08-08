package inhatc.aic.algorithm.ch01;

public class SumTwoWaysTrace {
    public static void main(String[] args) {
        int n = 8;
        long sum = 0;
        int operationCount = 0;

        System.out.println("[방법 A: 반복문] 1부터 " + n + "까지의 합 — 실행 추적");
        System.out.println("회차 | 더하는 값 i | 누적 합 sum | 누적 연산 횟수");
        System.out.println("-----+------------+------------+---------------");

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
            operationCount++;
            System.out.printf("%4d | %10d | %10d | %d%n", i, i, sum, operationCount);
        }

        System.out.println();
        System.out.println("[방법 B: 공식] " + n + " * (" + n + " + 1) / 2 = "
                + ((long) n * (n + 1) / 2) + "  (연산 1번에 종료)");
    }
}
