package inhatc.aic.algorithm.ch13;

public class BuggyNoGuard {

    public static void main(String[] args) {
        String[] requests = {"2005", "20A5", "3010"};

        for (String request : requests) {
            // 사용자 입력이 항상 숫자라고 믿어 버렸다!
            int code = Integer.parseInt(request);
            System.out.println("코드 " + code + " 검색을 시작합니다.");

//            try {
//                int code = Integer.parseInt(request);
//                System.out.println("코드 " + code + " 검색을 시작합니다.");
//            } catch (NumberFormatException e) {
//                System.out.println("오류: \"" + request + "\"은(는) 숫자가 아닙니다.");
//            }
        }

        System.out.println("모든 요청 처리 완료");
    }
}