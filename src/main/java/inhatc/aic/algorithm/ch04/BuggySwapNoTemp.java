package inhatc.aic.algorithm.ch04;

public class BuggySwapNoTemp {

    /** 두 칸의 값을 맞바꾸려고 했지만, 임시 변수를 빠뜨렸다. */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; // 임시 변수를 사용하지 않으면 arr[i]의 원래 값이 사라진다
        arr[i] = arr[j];   // 이 순간 arr[i]의 원래 값이 사라진다!
        arr[j] = temp;     // 임시 변수에 저장된 원래 값을 다시 넣는다
    }

    static String toText(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        int[] prices = {26, 15, 38, 12, 21};

        System.out.println("정렬 전: " + toText(prices));

        // 선택 정렬 — 반복 구조는 실습 코드의 selectionSort와 같다
        for (int i = 0; i < prices.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(prices, i, minIndex);
            }
        }

        System.out.println("정렬 후: " + toText(prices));
    }
}