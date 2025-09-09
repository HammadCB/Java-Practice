package Authentication;

import java.util.Scanner;

public class Login_Attempts {
    public static void main(String[] args) {
        // Hardcoded credentials
        String correctUsername = "admin";
        String correctPassword = "1234";

        Scanner sc = new Scanner(System.in);

        int attempts = 3; 

        while (attempts > 0) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login successful! Welcome, " + username);
                break; 
            } else {
                attempts--;
                System.out.println("Wrong username or password");
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
