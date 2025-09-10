package Arrays_List;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        System.out.print("How many names? ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names.add(sc.nextLine());
        }

        System.out.print("\nEnter a name to search: ");
        String search = sc.nextLine();

        if (names.contains(search)) {
            System.out.println(search + " found in the list!");
        } else {
            System.out.println(search + " not found.");
        }

        sc.close();
    }
}
