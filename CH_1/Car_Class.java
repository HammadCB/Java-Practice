package CH_1;
import java.util.Scanner;

class Car {
    String brand;
    int year;
}

public class Car_Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Car c1 = new Car();

        System.out.print("Enter car brand: ");
        c1.brand = sc.nextLine();

        System.out.print("Enter car year: ");
        c1.year = sc.nextInt();

        System.out.println("Car Brand: " + c1.brand);
        System.out.println("Car Year: " + c1.year);

        sc.close();
    }
}
