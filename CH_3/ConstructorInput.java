package CH_3;

import java.util.Scanner;

class Rectangle {
    int length;
    int width;

    // Constructor with input
    Rectangle(int l, int w) {
        length = l;
        width = w;
    }

    int area() {
        return length * width;
    }
}

public class ConstructorInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length: ");
        int l = sc.nextInt();

        System.out.print("Enter width: ");
        int w = sc.nextInt();

        Rectangle r1 = new Rectangle(l, w); // passing input to constructor
        System.out.println("Area = " + r1.area());

        sc.close();
    }
}
