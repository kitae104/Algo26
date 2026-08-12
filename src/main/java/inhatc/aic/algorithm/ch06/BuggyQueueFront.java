package inhatc.aic.algorithm.ch06;

public class BuggyQueueFront {

    static String[] queue = new String[8];
    static int front = 0;
    static int rear = 0;

    static void enqueue(String name) { queue[rear++] = name; }

    /** 맨 앞 고객을 꺼낸다 ... 고 생각했지만? */
    static String dequeue() {
        return queue[front];   // 값을 돌려주기만 한다
    }

//    static String dequeue() {
//        if (front == rear) {
//            System.out.println("경고: 빈 큐는 dequeue할 수 없습니다.");
//            return "?";
//        }
//        String value = queue[front];
//        front++;                  // 맨 앞 자리를 한 칸 뒤로 — 이 줄이 핵심!
//        return value;
//    }

    public static void main(String[] args) {
        enqueue("김하늘");
        enqueue("이준호");
        enqueue("박서연");

        for (int i = 1; i <= 3; i++) {
            System.out.println(i + "번째 처리: " + dequeue());
        }
        System.out.println("남은 대기 인원 = " + (rear - front));
    }
}