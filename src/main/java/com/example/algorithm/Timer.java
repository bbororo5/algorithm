package com.example.algorithm;

import java.util.function.Supplier;

public class Timer {
    public static <T> long measurePerformance(Supplier<T> methodToMeasure) {
        long startTime = System.nanoTime();
        T result = methodToMeasure.get();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
