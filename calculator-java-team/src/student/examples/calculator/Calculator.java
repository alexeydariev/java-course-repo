package student.examples.calculator;


import java.util.Scanner;

public class Calculator {
    public static void print(int value) {
        System.out.println("########################");
        System.out.println(value);
        System.out.println("########################");
    }

    public static int add(int a, int b) {
        int r = a + b;
        return r;
    }

    public static int subtract(int a, int b) {
        int r = a - b;
        return r;
    }

    public static int multiply(int a, int b) {
        int r = a * b;
        return r;
    }

    public static int divide(int a, int b) {
        int r = a / b;
        return r;
    }

    public static void ui() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Calculator: \n1.Add \n2.Subtract \n3.Multiply \n4.Divide \n0.Exit");
            System.out.println("Please, select an option:");
            int oper = in.nextInt();
            if (oper == 1) {
                System.out.println("Please, select an args:");
                System.out.println("Result: " + add(in.nextInt(), in.nextInt()));
            } else if (oper == 2) {
                System.out.println("Please, select an args:");
                System.out.println("Result: " + subtract(in.nextInt(), in.nextInt()));
            } else if (oper == 3) {
                System.out.println("Please, select an args:");
                System.out.println("Result: " + multiply(in.nextInt(), in.nextInt()));
            } else if (oper == 4) {
                System.out.println("Please, select an args:");
                System.out.println("Result: " + divide(in.nextInt(), in.nextInt()));
            } else if (oper == 0) {
                break;
            }
        }

    }
}
