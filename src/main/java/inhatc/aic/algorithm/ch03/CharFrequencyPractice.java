package inhatc.aic.algorithm.ch03;

import java.util.HashMap;
import java.util.Map;

public class CharFrequencyPractice {

    /** 단어에 들어 있는 각 문자의 등장 횟수를 HashMap으로 센다. */
    static Map<Character, Integer> countChars(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        return freq;
    }

    public static void main(String[] args) {
        String word = "banana";
        Map<Character, Integer> freq = countChars(word);

        System.out.println("단어: " + word);
        System.out.println("b = " + freq.getOrDefault('b', 0) + "회");
        System.out.println("a = " + freq.getOrDefault('a', 0) + "회");
        System.out.println("n = " + freq.getOrDefault('n', 0) + "회");
    }
}