package Exception_Handling;

import java.util.Scanner;

public class Multicatchh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int num1 = sc.nextInt();

            System.out.print("Enter denominator: ");
            int num2 = sc.nextInt();

            int result = num1 / num2;  
            System.out.println("Result: " + result);
        } 
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } 
        catch (Exception e) {  
            System.out.println("Something went wrong: " + e.getMessage());
        } 
        finally {
            System.out.println("Program finished.");
            sc.close();
        }
    }
}
