package Arrays_List.Hashset;

import java.util.HashSet;
import java.util.Scanner;

public class EmailRegistration {
    public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter email (or type 'exit'): ");
            String email = sc.nextLine();

            if (email.equalsIgnoreCase("exit")) break;

            if (emails.contains(email)) {
                System.out.println("⚠️ Email already registered!");
            } else {
                emails.add(email);
                System.out.println("✅ Email registered successfully.");
            }
        }

        System.out.println("All registered emails: " + emails);
        sc.close();
    }
}
