package inhatc.aic.algorithm.ch05;

public class BuggyLoopCondition {
    public static void main(String[] args) {
        int[] bookNumbers = {1001, 1203, 1450, 2088, 2311, 2754,
                3106, 3502, 3860, 4213, 4771, 5090};
        int target = 4213;

        int low = 0;
        int high = bookNumbers.length - 1;
        int foundIndex = -1;

        // 범위가 남아 있는 동안 절반씩 버리며 찾는다 (…라고 생각했다)
        while (low < high) {
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