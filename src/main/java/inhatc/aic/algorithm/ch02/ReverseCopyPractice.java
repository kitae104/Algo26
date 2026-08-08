package inhatc.aic.algorithm.ch02;

public class ReverseCopyPractice {

    /** scores를 역순으로 담은 "새 배열"을 만들어 반환한다. 원본은 바뀌지 않아야 한다. */
    static int[] reverseCopy(int[] scores) {
        int[] result = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            result[i] = scores[scores.length - 1 - i];
        }
        return result;
    }

    static void printArray(String title, int[] data) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (i > 0) line.append(", ");
            line.append(data[i]);
        }
        System.out.println(title + ": [" + line + "]");
    }

    public static void main(String[] args) {
        int[] scores = {72, 85, 90, 66, 78, 93, 55, 81};
        int[] reversed = reverseCopy(scores);

        printArray("원본 배열", scores);
        printArray("역순 복사", reversed);

        reversed[0] = 0;   // 복사본을 바꿔도
        printArray("복사본 수정 후 원본", scores);   // 원본은 그대로여야 한다
    }
}