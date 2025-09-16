package Projects.BigProjects;

import java.util.HashMap;
import java.util.Scanner;

// ======================= ITEM CLASS =======================
class Item {
    public int quantity;
    public double price;

    public Item(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
}

public class StoreSystemAdvanced {

    // ================= ADMIN LOGIN ==================
    private static boolean adminLogin(Scanner sc) {
        System.out.print("Enter Admin Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Admin Password: ");
        String pass = sc.nextLine();

        if (user.equals("admin") && pass.equals("1234")) {
            System.out.println("Admin login successful!");
            return true;
        } else {
            System.out.println("Wrong credentials.");
            return false;
        }
    }

    // ================= ADMIN MENU ==================
    private static void adminMenu(Scanner sc, HashMap<String, Item> inventory) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Update Quantity & Price");
            System.out.println("3. Display Inventory");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    inventory.put(name, new Item(qty, price));
                    System.out.println("Item added successfully.");
                    break;

                case 2:
                    System.out.print("Enter item to update: ");
                    String updateItem = sc.nextLine();
                    if (inventory.containsKey(updateItem)) {
                        System.out.print("Enter new quantity: ");
                        int newQty = sc.nextInt();
                        System.out.print("Enter new price: ");
                        double newPrice = sc.nextDouble();
                        sc.nextLine();
                        inventory.put(updateItem, new Item(newQty, newPrice));
                        System.out.println("Item updated successfully.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Inventory ---");
                    for (String key : inventory.keySet()) {
                        Item it = inventory.get(key);
                        System.out.println(key + " → " + it.quantity + " units @ $" + it.price);
                    }
                    break;

                case 4:
                    System.out.println("Logging out Admin...");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }}

    
