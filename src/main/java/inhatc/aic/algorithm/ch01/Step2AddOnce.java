package inhatc.aic.algorithm.ch01;

public class Step2AddOnce {
    public static void main(String[] args) {
        int[] scores = {72, 85, 90, 66, 78};

        int sum = 0;              // 누적 변수: 지금까지의 합을 기억한다

        sum = sum + scores[0];    // 핵심 연산: 값 하나를 누적한다

        System.out.println("첫 번째 점수를 더한 뒤 sum = " + sum);
    }
}