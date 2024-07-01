package Student.homework.exercise;

import java.util.Scanner;

public class SeaBigShip {
    public static void main(String[] args) {
        int big_ship;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the position of big ship:");
            big_ship = sc.nextInt();
        } while (big_ship < 2 || big_ship > 9);

        for(int x=1; x<11; x++) {
            if (x == big_ship) {
                System.out.print( "W" );
            } else if (x == (big_ship-1)||x == (big_ship+1)) {
                System.out.print( "w" );
            }
            else {
                System.out.print( "~" );
            }
        }
    }
}
