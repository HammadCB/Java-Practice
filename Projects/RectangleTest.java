package Projects;

import java.util.Scanner;

class Rectangle {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    // Getters
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }

    // Setters with validation
    public void setLength(double length) {
        if (length >= 0) {
            this.length = length;
        } else {
            System.out.println("Invalid length, setting to 0");
            this.length = 0;
        }
    }
    public void setWidth(double width) {
        if (width >= 0) {
            this.width = width;
        } else {
            System.out.println("Invalid width, setting to 0");
            this.width = 0;
        }
    }

    // Methods
    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }

    // Static method to manage multiple rectangles
    public static void manageRectangles() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rectangles: ");
        int n = sc.nextInt();

        Rectangle[] rects = new Rectangle[n];

        // Input
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Rectangle " + (i + 1));
            System.out.print("Length: ");
            double length = sc.nextDouble();
            System.out.print("Width: ");
            double width = sc.nextDouble();

            rects[i] = new Rectangle(length, width);
        }
sc.close();
        // Output
        System.out.println("\n--- Rectangle Areas & Perimeters ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Rectangle " + (i + 1) +
                               " -> Area: " + rects[i].area() +
                               ", Perimeter: " + rects[i].perimeter());
        }
    }
}

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle.manageRectangles();
    }
}
