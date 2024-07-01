package student.examples.calculator.tests;

public class TestRunner {
    public static void main(String[] args) {
        int testsPassed = 0;
        int testFailed = 0;
        if (Test.addition(1, 2, 3)) {
            System.out.println("Test addition passed");
            testsPassed++;
        } else {
            System.out.println("Test addition failed");
            testFailed++;
        }

        if (Test.subtraction(1, 2, -1)) {
            System.out.println("Test subtraction passed");
            testsPassed++;
        } else {
            System.out.println("Test subtraction failed");
            testFailed++;
        }

        if (Test.multiply(2, 2, -4)) {
            System.out.println("Test multiply passed");
            testsPassed++;
        } else {
            System.out.println("Test multiply failed");
            testFailed++;
        }
        System.out.println("Tests passed: " + testsPassed + "/3");
        System.out.println("Tests passed: " + testFailed + "/3");
        //Test.Addition(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])) ? System.out.println("Test passed") : System.out.println("Test failed");
        System.out.println();
    }
}
