package inhatc.aic.algorithm.ch11;

public class BuggyTableSize {
    public static void main(String[] args) {
        int n = 10;
        long[] dp = new long[n];        // dp[0]부터 dp[n]까지 쓸 계획인데...
//        long[] dp = new long[n + 1];   // 인덱스 0 ~ n → 크기 n + 1
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println("fibo(" + n + ") = " + dp[n]);
    }
}