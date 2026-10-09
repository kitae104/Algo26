package inhatc.aic.algorithm.ch05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ModernizeSolution {
    public static void main(String[] args) {

        List<Integer> bookNumbers = List.of(1001, 1203, 1450, 2088, 2311, 2754,
                3106, 3502, 3860, 4213, 4771, 5090);

        List<Integer> bookNumbers2 = List.of(1450, 1001, 1203,  5090, 2088, 3860,
                2311, 3502, 2754, 3106,  4213, 4771);

        List<Integer> targets = List.of(1001, 3106, 5090, 2500);   // 2500은 없는 번호

        System.out.println("도서 " + bookNumbers.size() + "권에서 번호 찾기");
        System.out.println();

        System.out.println("== 이미 정렬이 된 경우 탐색 ==");
        for (Integer target : targets) {
            int index = IntStream.range(0, bookNumbers.size())
                    .filter(i -> bookNumbers.get(i).equals(target))
                    .findFirst()
                    .orElse(-1);
            System.out.println("도서 번호 " + target + " → 인덱스 " + index);
        }
        System.out.println();

        System.out.println("== 목록에 있는 번호 ==");
        List<Integer> list = targets.stream().filter(target -> bookNumbers.contains(target))
                .toList();
        System.out.println("목록에 있는 번호: " + list);
        System.out.println();

        System.out.println("== 정렬이 되지 않은 경우 탐색 ==");
        List<Integer> list2 = new ArrayList<>(bookNumbers2);
        Collections.sort(list2, Collections.reverseOrder());
        System.out.println("역으로 정렬된 목록: " + list2);

        List<Integer> bookNumbers3 = bookNumbers2.stream().sorted().toList();

        for (Integer target : targets) {
            int index = IntStream.range(0, bookNumbers3.size())
                    .filter(i -> bookNumbers3.get(i).equals(target))
                    .findFirst()
                    .orElse(-1);
            System.out.println("도서 번호 " + target + " → 인덱스 " + index);
        }
        System.out.println();

        System.out.println("== 체이닝 방식으로 탐색 ==");
        List<Integer> bookNumbers4 = bookNumbers2.stream().sorted().toList();
        targets.forEach(target -> {
            System.out.println("도서 번호 " + target + " → 인덱스 " + bookNumbers4.indexOf(target));
        });
        System.out.println();

        System.out.println("== 이진 탐색 방식으로 탐색1 ==");
        List<Integer> bookNumbers5 = bookNumbers2.stream().sorted().toList();
        for (Integer target : targets) {
            int index = Collections.binarySearch(bookNumbers5, target);
            System.out.println("도서 번호 " + target + " → 인덱스 " + index);
        }

        System.out.println("== 이진 탐색 방식으로 탐색2 ==");
        List<Integer> bookNumbers6 = bookNumbers2.stream().sorted().toList();
        targets.forEach(target -> {
            int index = Collections.binarySearch(bookNumbers6, target);
            System.out.println("도서 번호 " + target + " → 인덱스 "+ index);
        });
    }


}
