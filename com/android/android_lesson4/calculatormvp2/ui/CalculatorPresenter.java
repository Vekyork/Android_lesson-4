package com.android.android_lesson4.calculatormvp2.ui;

import com.android.android_lesson4.calculatormvp2.domain.Calculator;
import com.android.android_lesson4.calculatormvp2.domain.Operator;

public class CalculatorPresenter {

    private final CalculatorView view;

    private final Calculator calculator;

    private int argumentOne = 0;

    private int argumentTwo = 0;

    private boolean isFirstArgument = true;

    private Operator operator = null;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;

        publishArgument();
    }

    public void keyOnePressed() {
        computeArg(1);

        publishArgument();
    }

    public void keyTwoPressed() {

        computeArg(2);

        publishArgument();
    }

    public void keyThreePressed() {

        computeArg(3);

        publishArgument();
    }

    public void keyPlusPressed() {
        isFirstArgument = false;

        if (operator != null) {

            int result = calculator.performBinaryOperator(argumentOne, argumentTwo, operator);

            view.showResult(String.valueOf(result));

            argumentOne = result;
            argumentTwo = 0;

        }

        operator = Operator.ADD;
    }

    private void publishArgument() {

        if (isFirstArgument) {
            view.showResult(String.valueOf(argumentOne));
        } else {
            view.showResult(String.valueOf(argumentTwo));
        }
    }

    private void computeArg(int addition) {
        if (isFirstArgument) {
            argumentOne = argumentOne * 10 + addition;
        } else {
            argumentTwo = argumentTwo * 10 + addition;
        }

    }

}
