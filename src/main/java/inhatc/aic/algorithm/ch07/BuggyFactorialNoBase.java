package inhatc.aic.algorithm.ch07;

public class BuggyFactorialNoBase {

    /** 팩토리얼을 재귀로 구하려 했지만, 종료 조건이 없다! */
    static long factorial(int n) {
        return n * factorial(n - 1);   // 자기 호출만 있고 멈추는 조건이 없다
    }

    public static void main(String[] args) {
        System.out.println("4! 계산을 시작합니다.");
        System.out.println("4! = " + factorial(4));
    }
}