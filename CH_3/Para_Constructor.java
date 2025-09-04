package CH_3;

class Car {
    String brand;
    int year;

    // Parameterized Constructor
    Car(String b, int y) {
        brand = b;
        year = y;
    }

    void show() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

public class Para_Constructor {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", 2020);
        Car c2 = new Car("Honda", 2022);

        c1.show();
        c2.show();
    }
}
