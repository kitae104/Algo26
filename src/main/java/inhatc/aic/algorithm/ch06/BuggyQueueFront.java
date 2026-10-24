package inhatc.aic.algorithm.ch06;

import java.util.ArrayDeque;
import java.util.Deque;

public class BuggyQueueFront {

    static Deque<String> queue = new ArrayDeque<>();

    static void enqueue(String name) {
        queue.offer(name);
    }

    /** 맨 앞 고객을 꺼낸다 */
    static String dequeue() {
        return queue.peek();
    }

    public static void main(String[] args) {
        enqueue("김하늘");
        enqueue("이준호");
        enqueue("박서연");

        for (int i = 1; i <= 3; i++) {
            System.out.println(i + "번째 처리: " + dequeue());
        }
        System.out.println("남은 대기 인원 = " + queue.size());
    }
}
