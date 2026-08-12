package inhatc.aic.algorithm.ch06;

public class BuggyBracketPop {

    static char[] stack = new char[100];
    static int top = -1;

    static void push(char value) { stack[++top] = value; }
    static char pop() { return stack[top--]; }

    /** 여는 괄호 open과 닫는 괄호 close가 서로 짝인지 확인한다 */
    static boolean isPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }

    static boolean isValid(String text) {
        top = -1;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
//                if (top == -1) {          // 빈 스택 검사가 pop보다 먼저!
//                    return false;         // 짝 없는 닫는 괄호 → 무효
//                }
                if (!isPair(pop(), ch)) {   // 닫는 괄호: 바로 pop해서 비교한다
                    return false;
                }
            }
        }
        return top == -1;
    }

    public static void main(String[] args) {
        System.out.println("() -> " + isValid("()"));
        System.out.println("()) -> " + isValid("())"));
    }
}
