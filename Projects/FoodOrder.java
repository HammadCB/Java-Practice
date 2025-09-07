package Projects;
import java.util.*;

// Abstract class (Abstraction)
abstract class FoodCategory {
 protected String name;
 public FoodCategory(String name) {
 this.name = name;
 }
 public abstract void showItems();
 public abstract void selectItem(int choice, Bill bill);
}


// Fast Food Category
class FastFood extends FoodCategory {
 public FastFood() {
 super("Fast Food");
 }
 @Override
 public void showItems() {
 System.out.println("\n--- Fast Food Menu ---");
 System.out.println("1. Burger - Rs.450");
 System.out.println("2. Pizza - Rs.1500");
 System.out.println("3. Fries - Rs.200");
 System.out.println("4. Sandwitchs - Rs.250");
 System.out.println("5. Chicken Nuggets - Rs.300");
 System.out.println("6. Chicken Steak - Rs.3000");
 }


 @Override
 public void selectItem(int choice, Bill bill) {
 Scanner sc = new Scanner(System.in);
 int qty;
 switch (choice) {
 case 1 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Burger", 450, qty);
 }
 case 2 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Pizza", 1500, qty);
 }
 case 3 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Fries", 200, qty);
 }
 case 4 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Sandwich", 250, qty);
 }
 case 5 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Chicken Nuggets", 300, qty);
 }
 case 6 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Chicken Steak", 3000, qty);
 sc.close();
 }
 default -> System.out.println("Invalid Fast Food choice.");
 }
 }
}






// Desserts Category
class Desserts extends FoodCategory {
 public Desserts() {
 super("Desserts");
 }
 @Override
 public void showItems() {
 System.out.println("\n--- Desserts Menu ---");
 System.out.println("1. Ice Cream - Rs.150");
 System.out.println("2. Cake - Rs.650");
 System.out.println("3. Donut - Rs.100");
 System.out.println("4. Pies - Rs.200");
 System.out.println("5. Cupcakes - Rs.150");
 }



 @Override
 public void selectItem(int choice, Bill bill) {
 Scanner sc = new Scanner(System.in);

 int qty;
switch (choice) {
 case 1 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Ice Cream", 150, qty);
 }
 case 2 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Cake", 650, qty);
 }
 case 3 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Donut", 100, qty);
 }
 case 4 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Pies", 200, qty);
 }
 case 5 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Cupcakes", 150, qty);
 sc.close();
 }
 default -> System.out.println("Invalid Dessert choice.");
 }
 }
}










// Drinks Category
class Drinks extends FoodCategory {
 public Drinks() {
 super("Drinks");
 }
 @Override
 public void showItems() {
 System.out.println("\n--- Drinks Menu ---");
 System.out.println("1. Coffee - Rs.150");
 System.out.println("2. Juice - Rs.200");
 System.out.println("3. Soda - Rs.350");
 }




 @Override
 public void selectItem(int choice, Bill bill) {
 Scanner sc = new Scanner(System.in);
 
 int qty;
 switch (choice) {
 case 1 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Coffee", 150, qty);
 }
 case 2 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 bill.addItem("Juice", 200, qty);
 }
 case 3 -> {
 System.out.print("Enter quantity: ");
 qty = sc.nextInt();
 
 bill.addItem("Soda", 350, qty);
 sc.close();
 }
 default -> System.out.println("Invalid Drink choice.");
 
 }
 }
}









// Encapsulation for Cart & Bill
class Bill {
 private List<String> items;
 private int total;
 public Bill() {
 items = new ArrayList<>();
 total = 0;
 }


 public void addItem(String item, int price, int quantity) {
 int cost = price * quantity;
 items.add(item + " x" + quantity + " = Rs" + cost);
 total += cost;
 System.out.println(item + " x" + quantity + " added to your cart.");
 }



 public void showBill() {
 if (items.isEmpty()) {
 System.out.println("\nYour cart is empty.");
 return;
 }
 System.out.println("\n------ YOUR CART ------");
 for (String item : items) {
 System.out.println(item);
 }
 System.out.println("Total Bill: Rs." + total);
 System.out.println("-----------------------");
 }
}







// Main System
class FoodOrderingSystem {
 private Scanner sc;
 private Bill bill;
 // Constructor
 public FoodOrderingSystem() {
 sc = new Scanner(System.in);
 bill = new Bill();
 }



 public void start() {
 while (true) {
 try {
 // Category Menu
 System.out.println("\n====== FOOD ORDERING SYSTEM ======");
 System.out.println("1. Fast Food");
 System.out.println("2. Desserts");
 System.out.println("3. Drinks");
 System.out.println("4. View Cart");
 System.out.println("0. Exit");
 System.out.print("Choose a category (0-4): ");
 int categoryChoice = sc.nextInt();
 FoodCategory category = null;

 if (categoryChoice == 0) {
 break; // exit program


 } else if (categoryChoice == 4) {
 bill.showBill();
continue;
 } else if (categoryChoice == 1) {
 category = new FastFood();
 } else if (categoryChoice == 2) {
 category = new Desserts();
 } else if (categoryChoice == 3) {
 category = new Drinks();
 } else {
 System.out.println("Invalid category.");


 
 }
 if (category != null) {
 category.showItems();
System.out.print("Select an item: ");
int itemChoice = sc.nextInt();
category.selectItem(itemChoice, bill);
 }
 } catch (InputMismatchException e) {
 System.out.println(" Invalid input! Please enter a number.");
 sc.nextLine(); // clear invalid input
 }
 }
 bill.showBill();
 System.out.println(" Your order is confirmed! Please wait while we prepare it.");
System.out.println("Thank you for ordering! Enjoy your meal.");
sc.close();
 }
}




public class FoodOrder {
 public static void main(String[] args) {
 FoodOrderingSystem system = new FoodOrderingSystem(); // constructor
 system.start();
 }
}