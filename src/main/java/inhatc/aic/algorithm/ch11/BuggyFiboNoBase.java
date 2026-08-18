package inhatc.aic.algorithm.ch11;

public class BuggyFiboNoBase {

    static long[] memo;

    /** 메모이제이션 피보나치 — 그런데 무언가 빠졌다! */
    static long fibo(int n) {
//        if (n <= 1) {
//            return n;          // 기저 조건이 가장 먼저!
//        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibo(n - 1) + fibo(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 30;
        memo = new long[n + 1];
        System.out.println("fibo(" + n + ") = " + fibo(n));
    }
}