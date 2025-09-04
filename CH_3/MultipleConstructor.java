package CH_3;

class Circle {
    double radius;

    // Default constructor
    Circle() {
        radius = 5.0; // default radius
    }

    // Parameterized constructor
    Circle(double r) {
        radius = r;
    }

    double area() {
        return 3.14 * radius * radius;
    }
}

public class MultipleConstructor {
    public static void main(String[] args) {
        Circle c1 = new Circle();       
        Circle c2 = new Circle(7.5);   

        System.out.println("Area (default): " + c1.area());
        System.out.println("Area (given): " + c2.area());
    }
}
