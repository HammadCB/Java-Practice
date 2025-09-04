package CH_1;


public class Class {
    public static void main(String[] args) {
        Car myCar = new Car();   // create object
        myCar.brand = "Toyota";
        myCar.year = 2020;

        System.out.println("Car brand: " + myCar.brand);
        System.out.println("Car year: " + myCar.year);
    }
}
class Car {
    String brand;
    int year;
}
