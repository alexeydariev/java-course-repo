package Student.example.chat.test;

import Student.example.chat.providers.IdentificationProvider;

import java.lang.reflect.Array;

public class IdentificationProviderTest {
    public static void main(String[] args) {
        int count1 = 0;
        int count2 = 0;
        int iterations = 1000000000;;
        IdentificationProvider identificationProvider = new IdentificationProvider();
        int value1 = identificationProvider.provide();
        int value2 = identificationProvider.provide();
        int countIdeal = iterations/identificationProvider.upperLimit;


        for (long i = 0; i < iterations; i++) {
            int id = identificationProvider.provide();
            if (id == value1) {
                count1++;
            } else if (id == value2) {
                count2++;
            }
        }
        int error1 = Math.abs(count1 - count2);
        int error2 = Math.abs(count1 - count2);
        
        System.out.println(countIdeal);
        System.out.println(value1 + " : " + count1);
        System.out.println(value2 + " : " + count2);
    }
}
