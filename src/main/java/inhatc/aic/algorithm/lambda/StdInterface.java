package inhatc.aic.algorithm.lambda;

import java.util.function.*;

public class StdInterface {
    public static void main(String[] args) {
        Predicate<Integer> pass    = s -> s >= 60;
        Function<Integer, String> toGrade = s -> s >= 90 ? "A" : s >= 80 ? "B" : "C";
        Consumer<String> print   = msg -> System.out.println("> " + msg);
        Supplier<String> empty   = () -> "(값 없음)";
        BinaryOperator<Integer> add     = (a, b) -> a + b;

        System.out.println(pass.test(72));       // true
        System.out.println(toGrade.apply(85));   // B
        print.accept("처리 완료");                // > 처리 완료
        System.out.println(empty.get());         // (값 없음)
        System.out.println(add.apply(3, 4));     // 7
    }
}
