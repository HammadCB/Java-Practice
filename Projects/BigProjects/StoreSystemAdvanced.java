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
            System.out.println(" Admin login successful!");
            return true;
        } else {
            System.out.println(" Wrong credentials.");
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

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("⚠ Invalid input! Please enter a number.");
                sc.nextLine(); 
                continue;
            }
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
                        String alert = it.quantity < 5 ? "Low stock!" : "";
                        System.out.println(key + " → " + it.quantity + " units @ $" + it.price + " " + alert);
                    }
                    break;

                case 4:
                    System.out.println("Logging out Admin...");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // ================= CUSTOMER MENU ==================

    private static void customerMenu(Scanner sc, HashMap<String, Item> inventory) {
        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Buy Item");
            System.out.println("2. View Price of Item");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("⚠ Invalid input! Please enter a number.");
                sc.nextLine(); 
                continue;
            }
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter item name to buy: ");
                    String itemName = sc.nextLine();
                    if (inventory.containsKey(itemName)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        sc.nextLine();

                        Item it = inventory.get(itemName);
                        if (qty <= it.quantity) {
                            it.quantity -= qty;
                            double total = qty * it.price;
                            System.out.println("You bought " + qty + " " + itemName + "(s) for $" + total);
                            if (it.quantity < 5) {
                                System.out.println("Alert: Low stock on " + itemName);
                            }
                        } else {
                            System.out.println(" Not enough stock available.");
                        }
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter item name: ");
                    String checkItem = sc.nextLine();
                    if (inventory.containsKey(checkItem)) {
                        Item it = inventory.get(checkItem);
                        System.out.println(checkItem + " → $" + it.price + " each (" + it.quantity + " in stock)");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Available Inventory ---");
                    for (String key : inventory.keySet()) {
                        Item it = inventory.get(key);
                        String alert = it.quantity < 5 ? "⚠ Low stock!" : "";
                        System.out.println(key + " → " + it.quantity + " units @ $" + it.price + " " + alert);
                    }
                    break;

                case 4:
                    System.out.println("Thank you for visiting!");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // ================= MAIN ==================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        HashMap<String, Item> inventory = new HashMap<>();
        inventory.put("Laptop", new Item(10, 1200));
        inventory.put("Phone", new Item(20, 600));
        inventory.put("Headphones", new Item(15, 100));

        System.out.println("--- Store System Started ---");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // clear buffer
                continue;
            }
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (adminLogin(sc)) {
                        adminMenu(sc, inventory);
                    }
                    break;

                case 2:
                    customerMenu(sc, inventory);
                    break;

                case 3:
                    System.out.println("Exiting Store System. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
