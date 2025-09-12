package Exception_Handling;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Exception1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int num = sc.nextInt();   
            System.out.println("You entered: " + num);
            sc.close();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers only.");
        }

        System.out.println("Program continues normally...");
    }
}
