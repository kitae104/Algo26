package inhatc.aic.algorithm.ch04;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortExample {
    public static void main(String[] args) {
        // 1-1. 기본형(int[]) 오름차순
        int[] numbers = {5, 2, 9, 1, 3};
        int[] numbers2 = Arrays.copyOf(numbers, numbers.length);

        Arrays.sort(numbers);
        System.out.println("오름차순 정렬: " + Arrays.toString(numbers));

//        Arrays.sort(numbers2, Collections.reverseOrder()); // 기본형 배열은 사용 불가

        Integer[] objNumbers = {5, 2, 9, 1, 3};
        Arrays.sort(objNumbers, Collections.reverseOrder());
        System.out.println("내림차순 정렬: " + Arrays.toString(objNumbers));

        // 특정 인덱스 구간만 정렬 (index 1부터 4 전까지)
        int[] partial = {5, 2, 9, 1, 3};
        Arrays.sort(partial, 1, 4); // index 1, 2, 3 대상
        System.out.println("부분 정렬: " + Arrays.toString(partial));
    }
}
