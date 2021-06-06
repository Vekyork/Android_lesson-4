package com.android.android_lesson4.calculatormvp2.domain;

public class CalculatorImpl implements Calculator {
    @Override
    public int performBinaryOperator(int argOne, int argTwo, Operator operator) {
        return argOne + argTwo;
    }
}
