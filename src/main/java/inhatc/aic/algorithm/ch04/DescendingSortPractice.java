package inhatc.aic.algorithm.ch04;

public class DescendingSortPractice {

    /** 버블 정렬을 내림차순으로: 이웃한 두 값 중 "작은 값"을 뒤로 보낸다. */
    static void bubbleSortDescending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
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

        System.out.println("정렬 전        : " + toText(prices));
        bubbleSortDescending(prices);
        System.out.println("내림차순 정렬 후: " + toText(prices));
        System.out.println("기대 결과      : [38, 26, 21, 15, 12]");
    }
}