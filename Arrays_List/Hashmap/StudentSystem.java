package Arrays_List.Hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> students = new HashMap<>();

        while (true) {
            System.out.println("\n--- Student System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    students.put(id, name);
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();
                    if (students.containsKey(searchId)) {
                        System.out.println("Found: " + students.get(searchId));
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.println("\nAll Students:");
                    for (int key : students.keySet()) {
                        System.out.println("ID: " + key + " _ Name: " + students.get(key));
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }}
