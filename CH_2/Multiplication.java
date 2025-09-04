package CH_2;

import java.util.Scanner;

class Calculator {
    int multiply(int a, int b) {
        return a * b;
    }
}

public class Multiplication{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator calc = new Calculator();

        System.out.print("Enter first number: ");
        int x = sc.nextInt();

        System.out.print("Enter second number: ");
        int y = sc.nextInt();

        int result = calc.multiply(x, y);
        System.out.println("Multiplication = " + result);

        sc.close();
    }
}
