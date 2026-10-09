package inhatc.aic.algorithm.ch05;

public class SearchAlgoMain {
    public static void main(String[] args) {
        SearchAlgo searchAlgo = new SearchAlgo();
        int[] bookNumbers = {1001, 1203, 1450, 2088, 2311, 2754,
                3106, 3502, 3860, 4213, 4771, 5090};
        int[] targets = {1001, 3106, 5090, 2500};

        // 선형 검색을 사용하여 각 target의 인덱스를 찾는다
        for (int target : targets) {
            int index = searchAlgo.linearSearch(bookNumbers, target);
            if (index != -1) {
                System.out.println("책 번호 " + target + "은(는) 배열의 인덱스 " + index + "에 있습니다.");
            } else {
                System.out.println("책 번호 " + target + "은(는) 배열에 없습니다.");
            }
        }

        // 이진 검색을 사용하여 각 target의 인덱스를 찾는다
        for (int target : targets) {
            int index = searchAlgo.binarySearch(bookNumbers, target);
            if (index != -1) {
                System.out.println("책 번호 " + target + "은(는) 배열의 인덱스 " + index + "에 있습니다.");
            } else {
                System.out.println("책 번호 " + target + "은(는) 배열에 없습니다.");
            }
        }
    }
}
