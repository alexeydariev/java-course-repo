package Student.homework.exercise;

import java.util.Scanner;

public class RestaurantApp {
    public static void main(String[] args) {

        // DATA LAYER
        final String CURRENCY = "MDL";

        final String FOOD_1_NAME = "Pizza";
        int food_1_available_quantity = 5;
        final float FOOD_1_PRICE = 75.5f;

        final String FOOD_2_NAME = "Mamaliga";
        int food_2_available_quantity = 5;
        final float FOOD_2_PRICE = 150f;

        final String FOOD_3_NAME = "Salad";
        int food_3_available_quantity = 5;
        final float FOOD_3_PRICE = 30f;

        // technical variables
        int option;
        int quantity;
        int confirmation;

        // PRESENTATION & LOGIC LAYER
        System.out.printf("\n********* MENU **********\n" +
                        "1. \"%-10s\" %7.2f %s\n" +
                        "2. \"%-10s\" %7.2f %s\n" +
                        "3. \"%-10s\" %7.2f %s\n" +
                        "*************************\n\n",
                FOOD_1_NAME, FOOD_1_PRICE, CURRENCY,
                FOOD_2_NAME, FOOD_2_PRICE, CURRENCY,
                FOOD_3_NAME, FOOD_3_PRICE, CURRENCY);

        do {
            System.out.print("CHOOSE AN OPTION >>>");
            Scanner in = new Scanner(System.in);
            option = in.nextInt();
        } while (option < 1 || option > 3);

        switch (option) {
            case 1:
                System.out.println("Your choice is: " + FOOD_1_NAME);
                break;
            case 2:
                System.out.println("Your choice is: " + FOOD_2_NAME);
                break;
            case 3:
                System.out.println("Your choice is: " + FOOD_3_NAME);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

        System.out.print("How many do you want ? ");
        Scanner in = new Scanner(System.in);
        quantity = in.nextInt();

        switch (option) {
            case 1:
                if (quantity < food_1_available_quantity) {
                    if (quantity*FOOD_1_PRICE > 200) {
                        System.out.printf("%d x \"%s\"   (%f) = %f\n",
                                quantity, FOOD_1_NAME, FOOD_1_PRICE, quantity*FOOD_1_PRICE);
                        System.out.println("The amount of the order exceeds 200 MDL, the delivery will be free");
                    } else {
                        System.out.println("The amount of the order is less than 200 MDL, the delivery will cost 50 MDL");
                        System.out.printf("%d x \"%s\"   (%f) + 50 Delivery = %f\n",
                                quantity, FOOD_1_NAME, FOOD_1_PRICE, quantity*FOOD_1_PRICE+50);
                    }
                    System.out.println("Confirm order ( 1 - yes, 0 - no )?");
                    confirmation = in.nextInt();
                    if (confirmation == 1) {
                        System.out.println("THANK YOU!");
                    } else {
                        System.out.println("Your order was declined");
                    }
                } else {
                    System.out.printf("You've ordered too many \"%s\", we only have %d\n" +
                            "PLEASE TRY AGAIN!", FOOD_1_NAME, food_1_available_quantity);
                }
                break;
            case 2:
                if (quantity < food_2_available_quantity) {
                    if (quantity*FOOD_1_PRICE > 200) {
                        System.out.printf("%d x \"%s\"   (%f) = %f\n",
                                quantity, FOOD_2_NAME, FOOD_2_PRICE, quantity*FOOD_2_PRICE);
                        System.out.println("The amount of the order exceeds 200 MDL, the delivery will be free");
                    } else {
                        System.out.println("The amount of the order is less than 200 MDL, the delivery will cost 50 MDL");
                        System.out.printf("%d x \"%s\"   (%f) + 50 Delivery = %f\n",
                                quantity, FOOD_2_NAME, FOOD_2_PRICE, quantity*FOOD_2_PRICE+50);
                    }
                    System.out.println("Confirm order ( 1 - yes, 0 - no )?");
                    confirmation = in.nextInt();
                    if (confirmation == 1) {
                        System.out.println("THANK YOU!");
                    } else {
                        System.out.println("Your order was declined");
                    }
                } else {
                    System.out.printf("You've ordered too many \"%s\", we only have %d\n" +
                            "PLEASE TRY AGAIN!", FOOD_2_NAME, food_2_available_quantity);
                }
                break;
            case 3:
                if (quantity < food_3_available_quantity) {
                    if (quantity*FOOD_1_PRICE > 200) {
                        System.out.printf("%d x \"%s\"   (%f) = %f\n",
                                quantity, FOOD_3_NAME, FOOD_3_PRICE, quantity*FOOD_3_PRICE);
                        System.out.println("The amount of the order exceeds 200 MDL, the delivery will be free");
                    } else {
                        System.out.println("The amount of the order is less than 200 MDL, the delivery will cost 50 MDL");
                        System.out.printf("%d x \"%s\"   (%f) + 50 Delivery = %f\n",
                                quantity, FOOD_3_NAME, FOOD_3_PRICE, quantity*FOOD_3_PRICE+50);
                    }
                    System.out.println("Confirm order ( 1 - yes, 0 - no )?");
                    confirmation = in.nextInt();
                    if (confirmation == 1) {
                        System.out.println("THANK YOU!");
                    } else {
                        System.out.println("Your order was declined");
                    }
                } else {
                    System.out.printf("You've ordered too many \"%s\", we only have %d\n" +
                            "PLEASE TRY AGAIN!", FOOD_3_NAME, food_3_available_quantity);
                }
                break;
        }


    }
}
