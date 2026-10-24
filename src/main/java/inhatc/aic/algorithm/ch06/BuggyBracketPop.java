package inhatc.aic.algorithm.ch06;

import java.util.ArrayDeque;
import java.util.Deque;

public class BuggyBracketPop {

    /** 여는 괄호 open과 닫는 괄호 close가 서로 짝인지 확인한다 */
    static boolean isPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }

    static boolean isValid(String text) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (!isPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("() -> " + isValid("()"));
        System.out.println("()) -> " + isValid("())"));
    }
}