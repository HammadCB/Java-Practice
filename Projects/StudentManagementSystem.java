package Projects;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Person {
    protected String name;
    protected String rollNumber;

    public Person(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public abstract void showDetails();
}

class Student extends Person {
    private String department;
    private double gpa;

    public Student(String name, String rollNumber, String department, double gpa) {
        super(name, rollNumber);
        this.department = department;
        this.gpa = gpa;
    }

    @Override
    public void showDetails() {
        System.out.println("Name: " + name + " | Roll: " + rollNumber +
                " | Department: " + department + " | GPA: " + gpa);
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }
}

// New class to manage everything
class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void startMenu() {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Update GPA");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> showAll();
                case 3 -> updateGPA();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        String roll = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter GPA: ");
        double gpa = sc.nextDouble();
        sc.nextLine();

        students.add(new Student(name, roll, dept, gpa));
        System.out.println("Student added successfully!");
    }

    private void showAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            s.showDetails();
        }
    }

    private void updateGPA() {
        System.out.print("Enter Roll No to update GPA: ");
        String roll = sc.nextLine();
        for (Student s : students) {
            if (s.getRollNumber().equals(roll)) {
                System.out.print("Enter new GPA: ");
                double gpa = sc.nextDouble();
                sc.nextLine();
                s.setGPA(gpa);
                System.out.println("GPA updated!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        sm.startMenu();
    }
}
