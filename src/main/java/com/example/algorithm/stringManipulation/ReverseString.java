package com.example.algorithm.stringManipulation;

import com.example.algorithm.Timer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseString {

    public static char[] reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return s;
    }

    public static char[] reverseStringPythonic(char[] s) {
        List<Character> charList = new ArrayList<>();
        for (char c : s) {
            charList.add(c);
        }
        Collections.reverse(charList);
        for (int i = 0; i < s.length; i++) {
            s[i] = charList.get(i);
        }
        return s;
    }

    public static void main(String[] args) {
        char[] test1 = {'h', 'e', 'l', 'l', 'o'};

        long time1_1 = Timer.measurePerformance(() -> reverseString(test1));
        String result1_1 = Arrays.toString(reverseString(test1));
        System.out.println("시간: " + time1_1 + " ns");
        System.out.println("결과: " + result1_1);

        long time1_2 = Timer.measurePerformance(() -> reverseStringPythonic(test1));
        String result1_2 = Arrays.toString(reverseStringPythonic(test1));
        System.out.println("시간: " + time1_2 + " ns");
        System.out.println("결과: " + result1_2);
    }

}
