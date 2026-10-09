package inhatc.aic.algorithm.ch05;

public class SearchAlgo{

    /**
     * 선형 검색: 배열을 처음부터 끝까지 순차적으로 탐색하며 target을 찾는다.
     * @param arr
     * @param target
     * @return
     */
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 이진 검색: 배열이 정렬되어 있을 때, 중간 값을 기준으로 target을 찾는다.
     * @param arr
     * @param target
     * @return
     */
    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
