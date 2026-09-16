package inhatc.aic.algorithm.ch02;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ScoreStatsStream {

    /**
     * 합계
     */
    static int sum(int[] data) {
        return Arrays.stream(data).sum();
    }

    /**
     * 평균
     */
    static double average(int[] data) {
        return Arrays.stream(data).average().orElse(Double.NaN);
    }

    /**
     * 최댓값
     */
    static int max(int[] data) {
        return Arrays.stream(data).max().orElseThrow();
    }

    /**
     * 최솟값
     */
    static int min(int[] data) {
        return Arrays.stream(data).min().orElseThrow();
    }

    /**
     * threshold점 이상인 원소의 개수
     */
    static int countAtLeast(int[] data, int threshold) {
        return (int) Arrays.stream(data).filter(score -> score >= threshold).count();
    }

    /**
     * limit 미만인 원소만 새로운 배열로 반환
     */
    static int[] collectBelow(int[] data, double limit) {
        return Arrays.stream(data).filter(score -> score < limit).toArray();
    }

    /**
     * 점수대별 인원 계산
     */
    static int[] bandCounts(int[] data) {

        return Arrays.stream(data).collect(() -> new int[10],

                // 각 점수의 점수대 카운트 증가
                (bands, score) -> bands[score / 10]++,

                // 병렬 스트림 사용 시 결과 병합
                (bands1, bands2) -> {
                    for (int i = 0; i < bands1.length; i++) {
                        bands1[i] += bands2[i];
                    }
                });
    }

    public static void main(String[] args) {

        int[] scores = {72, 85, 90, 66, 78, 93, 55, 81};

        double avg = average(scores);

        System.out.println("== 성적 통계 리포트 ==");
        System.out.println("학생 수   : " + scores.length + "명");
        System.out.println("합계      : " + sum(scores) + "점");
        System.out.printf("평균      : %.1f점%n", avg);
        System.out.println("최고점    : " + max(scores) + "점");
        System.out.println("최저점    : " + min(scores) + "점");
        System.out.println("80점 이상 : " + countAtLeast(scores, 80) + "명");


        // 평균 미만 점수
        int[] belowAvg = collectBelow(scores, avg);
        String line = Arrays.stream(belowAvg).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("평균 미만 : " + belowAvg.length + "명 [" + line + "]");

        // 점수대별 인원
        int[] bands = bandCounts(scores);
        String distribution = Arrays.stream(new int[]{5, 6, 7, 8, 9})
                .mapToObj(band -> band * 10 + "점대 " + bands[band] + "명")
                .collect(Collectors.joining(" | "));
        System.out.println("점수대 분포: " + distribution);
    }
}