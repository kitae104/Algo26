package inhatc.aic.algorithm.ch11;

public class MaxSubarrayPractice {

    /** dp[i] = "i번 원소에서 끝나는" 연속 부분합의 최댓값 */
    static int maxSubarraySum(int[] data) {
        int n = data.length;
        int[] dp = new int[n];
        dp[0] = data[0];        // 기저 조건: 첫 원소에서 끝나는 부분합은 자기 자신뿐
        int best = dp[0];

        for (int i = 1; i < n; i++) {
            // TODO: 점화식으로 dp[i]를 채우세요.
            //       dp[i] = max(data[i], dp[i - 1] + data[i])
            //       (앞의 합을 이어받는 게 손해면 i에서 새로 시작한다)
            dp[i] = Math.max(data[i], dp[i - 1] + data[i]);

            if (dp[i] > best) {
                best = dp[i];   // 지금까지의 최댓값 갱신
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] sales = {3, -5, 4, -1, 6, -8, 2};
        System.out.println("최대 연속 부분합 = " + maxSubarraySum(sales) + " (기대값 9)");
    }
}