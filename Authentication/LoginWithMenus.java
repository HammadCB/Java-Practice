package Authentication;


import java.util.Scanner;

public class LoginWithMenus {
    public static void main(String[] args) {
        // Hardcoded credentials
        String adminUser = "admin";
        String adminPass = "1234";

        String normalUser = "user";
        String userPass = "0000";

        Scanner sc = new Scanner(System.in);

        int attempts = 3; 
        boolean loggedIn = false;
        boolean isAdmin = false;

        while (attempts > 0) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (username.equals(adminUser) && password.equals(adminPass)) {
                System.out.println("Login successful! Welcome Admin.");
                loggedIn = true;
                isAdmin = true;
                break;
            } else if (username.equals(normalUser) && password.equals(userPass)) {
                System.out.println("Login successful! Welcome User.");
                loggedIn = true;
                isAdmin = false;
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

        // After login, show menu
        if (loggedIn) {
            if (isAdmin) {
                int choice;
                do {
                    System.out.println("\n--- Admin Menu ---");
                    System.out.println("1. Register new user");
                    System.out.println("2. View all users");
                    System.out.println("3. System settings");
                    System.out.println("4. Logout");
                    System.out.print("Enter your choice: ");
                    choice = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    switch (choice) {
                        case 1 -> System.out.println("➡ Registering new user...");
                        case 2 -> System.out.println("➡ Showing all users...");
                        case 3 -> System.out.println("➡ Accessing system settings...");
                        case 4 -> System.out.println("Logged out from Admin account.");
                        default -> System.out.println("Invalid choice.");
                    }
                } while (choice != 4);
            } else {
                int choice;
                do {
                    System.out.println("\n--- User Menu ---");
                    System.out.println("1. Deposit money");
                    System.out.println("2. Withdraw money");
                    System.out.println("3. Check balance");
                    System.out.println("4. Logout");
                    System.out.print("Enter your choice: ");
                    choice = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    switch (choice) {
                        case 1 -> System.out.println("➡ Depositing money...");
                        case 2 -> System.out.println("➡ Withdrawing money...");
                        case 3 -> System.out.println("➡ Checking balance...");
                        case 4 -> System.out.println("Logged out from User account.");
                        default -> System.out.println("Invalid choice.");
                    }
                } while (choice != 4);
            }
        }

        sc.close();
    }
}
