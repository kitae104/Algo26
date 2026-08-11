package inhatc.aic.algorithm.ch05;

public class MidOverflowDemo {
    public static void main(String[] args) {
        // 도서 수십억 권짜리 거대한 배열을 탐색하는 중이라고 가정하자
        int low = 1500000000;    // 15억
        int high = 1600000000;   // 16억

        int riskyMid = (low + high) / 2;        // 위험한 계산
        int safeMid = low + (high - low) / 2;   // 안전한 계산

        System.out.println("(low + high) / 2       = " + riskyMid);
        System.out.println("low + (high - low) / 2 = " + safeMid);
    }
}