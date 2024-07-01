package Student.homework.exercise.dataflowapp;

public class DataFlowApp {
    public static void main(String[] args) {
        // in range values
        byte numberByte = 19;
        short numberShort = 19;
        int numberInt = 19;
        double numberDouble = 19.1;
        // out of range values
        int numberIntOut = 2000000;
        double numberDoubleOut = 3000000000d;
        double numberBonus = 1.5;
        // Positive test
        System.out.println(DataTransformer.integerToByte(numberInt));
        System.out.println(DataTransformer.byteToInteger(numberByte));
        System.out.println(DataTransformer.doubleToInteger(numberDouble));
        System.out.println(DataTransformer.integerToDouble(numberInt));
        System.out.println(DataTransformer.shortToInteger(numberShort));
        System.out.println(DataTransformer.integerToShort(numberInt));
        // Negative test
        System.out.println(DataTransformer.integerToByte(numberIntOut));
        System.out.println(DataTransformer.doubleToInteger(numberDoubleOut));
        System.out.println(DataTransformer.integerToShort(numberIntOut));
        // Bonus 1.5 din Double in Short
        System.out.println(DataTransformer.doubleToShort(numberBonus));
    }
}

class DataTransformer {

    static byte integerToByte(int n) {
        if (n>=-128 && n<=127) {
            return (byte)n;
        } else {
            System.err.println("WARNING! the value \""+n+"\" " +
                    "overflows \"byte\" range. DATA will was lost!");
            return 0;
        }
    }
    static int byteToInteger(byte n) {
        return (int)n;
    }
    static int doubleToInteger(double n) {
        // -2,147,483,648 până la 2,147,483,647
        if (n>= -2147483648 && n<=2147483647) {
            return (int)n;
        } else {
            System.err.println("WARNING! the value \""+n+"\" " +
                    "overflows \"integer\" range. DATA will was lost!");
            return 0;
        }
    }
    static double integerToDouble(int n) {
        return (double)n;
    }
    static int shortToInteger(short n) {
        return (int)n;
    }
    static short integerToShort(int n) {
        // -32,768 până la 32,767
        if (n>=-32768 && n<=32767) {
            return (short)n;
        } else {
            System.err.println("WARNING! the value \""+n+"\" " +
                    "overflows \"short\" range. DATA will was lost!");
            return 0;
        }
    }
    static short doubleToShort(double n) {
        // -32,768 până la 32,767
        if (n>=-32768 && n<=32767) {
            return (short)n;
        } else {
            System.err.println("WARNING! the value \""+n+"\" " +
                    "overflows \"short\" range. DATA will was lost!");
            return 0;
        }
    }
}