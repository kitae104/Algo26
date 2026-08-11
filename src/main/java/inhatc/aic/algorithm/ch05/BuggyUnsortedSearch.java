package inhatc.aic.algorithm.ch05;

public class BuggyUnsortedSearch {
    public static void main(String[] args) {
        // 반납된 순서 그대로라 아직 정렬되지 않은 도서 번호
        int[] bookNumbers = {3106, 1001, 2754, 5090, 1203, 4213};
        int target = 1001;   // 인덱스 1에 분명히 있다

        int low = 0;
        int high = bookNumbers.length - 1;
        int foundIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (bookNumbers[mid] == target) {
                foundIndex = mid;
                break;
            } else if (bookNumbers[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("도서 번호 " + target + " → 인덱스 " + foundIndex);
    }
}