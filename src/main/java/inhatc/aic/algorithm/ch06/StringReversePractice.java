package inhatc.aic.algorithm.ch06;

public class StringReversePractice {

    /** 스택을 이용해 text를 뒤집은 문자열을 반환한다 */
    static String reverse(String text) {
        char[] stack = new char[text.length()];
        int top = -1;

        // TODO 1: text의 모든 문자를 앞에서부터 순서대로 스택에 push하세요.
        //         (힌트: stack[++top] = text.charAt(i))
        for (int i = 0; i < text.length(); i++) {
            stack[++top] = text.charAt(i);      // 앞에서부터 전부 push
        }

        StringBuilder result = new StringBuilder();
        // TODO 2: 스택이 빌 때까지(top != -1) pop한 문자를 result에 붙이세요.
        //         (힌트: result.append(stack[top--]))
        while (top != -1) {
            result.append(stack[top--]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] tests = {"stack", "abc", "a"};
        for (String t : tests) {
            System.out.println("\"" + t + "\" -> \"" + reverse(t) + "\"");
        }
    }
}