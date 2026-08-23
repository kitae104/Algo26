package inhatc.aic.algorithm.lambda;

@FunctionalInterface          // 추상 메서드가 둘 이상이면 컴파일 오류로 알려 준다
interface ScoreRule {
    boolean test(int score);  // 추상 메서드는 이것 하나뿐
}

public class RuleDemo {
    // 규칙을 "값"으로 받는다 — 세는 방법은 하나, 세는 기준은 호출자가 정한다
    static int countBy(int[] scores, ScoreRule rule) {
        int count = 0;
        for (int s : scores) {
            if (rule.test(s)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] scores = {88, 72, 95, 64, 79, 91};

        System.out.println("80점 이상: " + countBy(scores, s -> s >= 80));
        System.out.println("60점 미만: " + countBy(scores, s -> s < 60));
        System.out.println("짝수 점수: " + countBy(scores, s -> s % 2 == 0));
        // countBy는 한 번도 고치지 않았다. 바뀐 것은 넘긴 규칙뿐이다.
    }
}