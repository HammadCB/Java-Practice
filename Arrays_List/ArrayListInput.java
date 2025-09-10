package Arrays_List;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        // input
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers.add(sc.nextInt());
        }

        // Display numbers
        System.out.println("\nNumbers you entered:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
