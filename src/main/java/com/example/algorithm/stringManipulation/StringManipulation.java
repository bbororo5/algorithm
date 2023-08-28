package com.example.algorithm.stringManipulation;

import com.example.algorithm.Timer;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringManipulation {

    public static boolean isPalindromeWithStringBuilder(String s) {
        StringBuilder cleaned = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        String cleanedString = cleaned.toString();
        int left = 0, right = cleanedString.length() - 1;

        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeWithDeque(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                deque.add(Character.toLowerCase(c));
            }
        }

        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "A man, a plan, a canal: Panama";

        String test3 = "장상창홍방창상장";

        long time1_1 = Timer.measurePerformance(() -> isPalindromeWithStringBuilder(test1));
        boolean result1_1 = isPalindromeWithStringBuilder(test1);
        System.out.println("시간: " + time1_1 + " ns");
        System.out.println("결과: " + result1_1);

        long time2_1 = Timer.measurePerformance(() -> isPalindromeWithDeque(test1));
        boolean result2_1 = isPalindromeWithDeque(test1);
        System.out.println("시간: " + time2_1 + " ns");
        System.out.println("결과: " + result2_1);

        long time1_3 = Timer.measurePerformance(() -> isPalindromeWithStringBuilder(test3));
        boolean result1_3 = isPalindromeWithStringBuilder(test1);
        System.out.println("시간: " + time1_3 + " ns");
        System.out.println("결과: " + result1_3);

        long time2_3 = Timer.measurePerformance(() -> isPalindromeWithDeque(test3));
        boolean result2_3 = isPalindromeWithDeque(test1);
        System.out.println("시간: " + time2_3 + " ns");
        System.out.println("결과: " + result2_3);
    }
}

