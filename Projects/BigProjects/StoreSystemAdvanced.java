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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inventory (product name → Item object)
        HashMap<String, Item> inventory = new HashMap<>();
        inventory.put("Laptop", new Item(10, 1200));
        inventory.put("Phone", new Item(20, 600));
        inventory.put("Headphones", new Item(15, 100));

        System.out.println("--- Store System Setup Complete ---");
        sc.close();
    }
}