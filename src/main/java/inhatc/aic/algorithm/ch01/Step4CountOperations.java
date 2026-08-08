package inhatc.aic.algorithm.ch01;

public class Step4CountOperations {
    public static void main(String[] args) {
        int[] scores = {72, 85, 90, 66, 78};

        int sum = 0;
        int operationCount = 0;   // 핵심 연산 실행 횟수

        for (int i = 0; i < scores.length; i++) {
            sum = sum + scores[i];
            operationCount++;     // 누적 연산을 할 때마다 1 증가
        }

        System.out.println("점수 합계 = " + sum);
        System.out.println("데이터 개수 n = " + scores.length);
        System.out.println("누적 연산 실행 횟수 = " + operationCount);
    }
}