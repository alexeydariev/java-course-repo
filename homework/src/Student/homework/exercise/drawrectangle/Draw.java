package Student.homework.exercise.drawrectangle;

public class Draw {
    public static void main(String[] args) {
        HorizontalLine.drawLine(3);
        VerticalLine.drawLine(3);
        HorizontalLine.drawLine();
        VerticalLine.drawLine();
        Rectangle.drawRect(9,2);
        Rectangle.drawRect();
        HorizontalLine.drawLine();
        System.out.println("Example from exercise");
        HorizontalLine.drawLine(7);
        VerticalLine.drawLine(3);
        Rectangle.drawRect(4,4);
    }
}

class Shape {
    static void drawHash() {
        System.out.print("#");
    }
    static void drawSpace() {
        System.out.print(" ");
    }
    static void newLine() {
        System.out.print("\n");
    }
}

class HorizontalLine extends Shape {
    static void drawLine(int length) {
        newLine();
        for(int i=0; i<length; i++){
            drawHash();
        }
        newLine();
    }
    static void drawLine() {
        newLine();
        for(int i=0; i<5; i++){
            drawHash();
        }
        newLine();
    }
}

class VerticalLine extends Shape {
    static void drawLine(int length) {
        newLine();
        for (int i = 0; i < length; i++) {
            drawHash();
            newLine();
        }
    }

    static void drawLine() {
        newLine();
        for (int i = 0; i < 5; i++) {
            drawHash();
            newLine();
        }
    }
}

class Rectangle extends Shape {
    static void drawRect(int width, int hight) {
        newLine();
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < width; j++) {
                drawHash();
            }
            newLine();
        }
    }

    static void drawRect() {
        newLine();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                drawHash();
            }
            newLine();
        }
    }
}
