package Student.homework.exercise;

import java.util.Scanner;

public class DrawCakeWithForApp {

    public static void main(String[] args) {

        final int SMOKE  = 1;
        final int FIRE   = 2;
        final int CANDLE = 3;
        final int CREAM  = 4;
        final int BASE   = 5;
        int width;

        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the width of the cake: ");
            width = in.nextInt();
        } while (width <= 0);


        for(int level=1; level<=5 ;level++) {
            switch(level) {
                case SMOKE:
                    for(int lines=1; lines<=2; lines++) {
                        for(int elements=1; elements<=width; elements++) {
                            System.out.print(".");
                        }
                    System.out.println();
                    }
                    break;
                case FIRE:
                    for(int elements=1; elements<=width; elements++) {
                        System.out.print("^");
                    }
                    System.out.println();
                    break;
                case CANDLE:
                    for(int elements=1; elements<=width; elements++) {
                        System.out.print("|");
                    }
                    System.out.println();
                    break;
                case CREAM:
                    for(int elements=1; elements<=width; elements++) {
                        System.out.print("~");
                    }
                    System.out.println();
                    break;
                case BASE:
                    for(int lines=1; lines<=3; lines++) {
                        for(int elements=1; elements<=width; elements++) {
                            System.out.print("#");
                        }
                        System.out.println();
                    }
                    break;
            }
        }


    }
}