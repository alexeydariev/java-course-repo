package student.examples.calculator.tests;

import student.examples.calculator.Calculator;

public class Test {
    public static boolean addition(int in1, int in2, int out) {
        if (Calculator.add(in1, in2) == out) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean subtraction(int in1, int in2, int out) {
        return Calculator.subtract(in1, in2) == out ? true : false;
    }

    public static boolean multiply(int in1, int in2, int out) {
        return Calculator.multiply(in1, in2) == out;
    }
}
