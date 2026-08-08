package inhatc.aic.algorithm.ch01;

public class BuggyFormulaOverflow {
    public static void main(String[] args) {
        int n = 100000;

        // 가우스 공식으로 1부터 n까지의 합을 구한다
        long sum = n * (n + 1) / 2;

        System.out.println("1부터 " + n + "까지의 합 = " + sum);
    }
}