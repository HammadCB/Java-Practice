package Authentication;

import java.util.Scanner;

public class Login_Roles {
    public static void main(String[] args) {
        // Hardcode
        String adminUser = "admin";
        String adminPass = "1234";

        String normalUser = "user";
        String userPass = "0000";

        Scanner sc = new Scanner(System.in);

        int attempts = 3; 

        while (attempts > 0) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (username.equals(adminUser) && password.equals(adminPass)) {
                System.out.println("Login successful! Welcome Admin.");
                System.out.println("You now have admin privileges.");
                break; 
            } else if (username.equals(normalUser) && password.equals(userPass)) {
                System.out.println("Login successful! Welcome User.");
                System.out.println("You now have limited access.");
                break; 
            } else {
                attempts--;
                System.out.println("Wrong username or password.");
                if (attempts > 0) {
                    System.out.println("You have " + attempts + " attempts left.");
                } else {
                    System.out.println("Account locked! Too many failed attempts.");
                }
            }
        }

        sc.close();
    }
}
