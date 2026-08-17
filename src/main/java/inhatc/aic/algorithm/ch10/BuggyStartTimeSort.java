package inhatc.aic.algorithm.ch10;

import java.util.ArrayList;
import java.util.List;

public class BuggyStartTimeSort {

    /** 회의 정보를 담는 작은 기록용 클래스 */
    static class Meeting {
        String name;
        int start;
        int end;

        Meeting(String name, int start, int end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }
    }

    /** 시작 시각(start) 기준으로 정렬한다 — 여기가 잘못된 부분이다. */
    static void sortByStartTime(Meeting[] meetings) {
        for (int i = 1; i < meetings.length; i++) {
            Meeting key = meetings[i];
            int j = i - 1;
            while (j >= 0 && meetings[j].start > key.start) {
                meetings[j + 1] = meetings[j];
                j--;
            }
//            while (j >= 0 && meetings[j].end > key.end) {   // start가 아니라 end!
//                meetings[j + 1] = meetings[j];
//                j--;
//            }
            meetings[j + 1] = key;
        }
    }

    static List<Meeting> selectMeetings(Meeting[] sorted) {
        List<Meeting> selected = new ArrayList<>();
        int lastEnd = Integer.MIN_VALUE;

        for (Meeting m : sorted) {
            if (m.start >= lastEnd) {
                selected.add(m);
                lastEnd = m.end;
            }
        }
        return selected;
    }

    public static void main(String[] args) {
        Meeting[] meetings = {
                new Meeting("전략 기획", 8, 12),
                new Meeting("디자인 리뷰", 9, 10),
                new Meeting("개발 스탠드업", 10, 11),
                new Meeting("고객 미팅", 11, 13),
                new Meeting("채용 면접", 12, 14),
                new Meeting("팀 회고", 13, 15)
        };

        sortByStartTime(meetings);
        List<Meeting> selected = selectMeetings(meetings);

        System.out.println("[선택된 회의]");
        for (Meeting m : selected) {
            System.out.println(m.name + " (" + m.start + "시 ~ " + m.end + "시)");
        }
        System.out.println("최대 " + selected.size() + "개의 회의를 열 수 있습니다.");
    }
}