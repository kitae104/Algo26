package inhatc.aic.algorithm.ch07;

public class BuggyHanoiNoBase {

    static int moveCount = 0;

    /** 하노이 탑: n개의 원반을 from에서 to로 옮긴다 */
    static void hanoi(int n, char from, char to, char via) {

//        if (n == 1) {      // 종료 조건: 원반 1개는 바로 옮기고 재귀를 멈춘다
//            moveCount++;
//            System.out.println("이동 " + moveCount + ": 원반 1 (" + from + " -> " + to + ")");
//            return;
//        }

        hanoi(n - 1, from, via, to);
        moveCount++;
        System.out.println("이동 " + moveCount + ": 원반 " + n + " (" + from + " -> " + to + ")");
        hanoi(n - 1, via, to, from);
    }

    public static void main(String[] args) {
        System.out.println("원반 3개 옮기기를 시작합니다.");
        hanoi(3, 'A', 'C', 'B');
        System.out.println("총 " + moveCount + "번 이동");
    }
}