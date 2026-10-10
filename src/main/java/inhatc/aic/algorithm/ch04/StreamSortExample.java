package inhatc.aic.algorithm.ch04;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortExample {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 3};

        int[] sortedNumbers = Arrays.stream(numbers)
                .sorted()
                .toArray();
        System.out.println("정렬된 배열: " + Arrays.toString(sortedNumbers));

        // 내림차순 정렬
        int[] descSortedNumbers = Arrays.stream(numbers)
                .boxed() // int[]를 Integer[]로 변환
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("내림차순 정렬된 배열: " + Arrays.toString(descSortedNumbers));

        List<Integer> list = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());

        // 오름차순 정렬
        list.sort(Comparator.naturalOrder());
        System.out.println("List 오름차순: " + list); // [1, 2, 3, 5, 9]

        // 내림차순 정렬 (Collections.sort 사용 예시)
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("List 내림차순: " + list); // [9, 5, 3, 2, 1]

        // 3-2. 다시 배열로 되돌리기
        int[] backToArray = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("배열로 복원: " + Arrays.toString(backToArray));
    }
}
