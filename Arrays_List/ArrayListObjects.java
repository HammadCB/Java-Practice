package Arrays_List;

import java.util.ArrayList;
import java.util.Scanner;

class User {
    String username;
    String password;

    User(String u, String p) {
        username = u;
        password = p;
    }
}

public class ArrayListObjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();

        System.out.print("How many users? ");
        int n = sc.nextInt();
        sc.nextLine();

        // Register users
        for (int i = 0; i < n; i++) {
            System.out.print("Enter username: ");
            String u = sc.nextLine();

            System.out.print("Enter password: ");
            String p = sc.nextLine();

            users.add(new User(u, p));
        }

        // Display users
        System.out.println("\nRegistered Users:");
        for (User user : users) {
            System.out.println("Username: " + user.username + ", Password: " + user.password);
        }

        sc.close();
    }
}
