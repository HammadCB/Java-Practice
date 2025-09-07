package Projects;


import java.util.Scanner;

// Base class Employee
class Employee {
    protected String name;
    private double baseSalary;

    // Constructor
    public Employee(String name, double baseSalary) {
        this.name = name;
        setBaseSalary(baseSalary);
    }

    // Getter & Setter
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            System.out.println("Salary cannot be negative!");
            this.baseSalary = 0;
        }
    }

    // Method to be overridden
    public double calculateSalary() {
        return baseSalary;
    }

    public void showDetails() {
        System.out.println("Employee: " + name + " | Salary: " + calculateSalary());
    }
}

// Subclass Manager
class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + " | Salary: " + calculateSalary());
    }
}

// Main Class
public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[3];

        for (int i = 0; i < employees.length; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Is this employee a manager? (yes/no): ");
            String type = sc.next();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Base Salary: ");
            double salary = sc.nextDouble();

            if (type.equalsIgnoreCase("yes")) {
                System.out.print("Bonus: ");
                double bonus = sc.nextDouble();
                employees[i] = new Manager(name, salary, bonus);
            } else {
                employees[i] = new Employee(name, salary);
            }
        }
        sc.close();

        // Show details using polymorphism
        System.out.println("\n--- Payroll Details ---");
        for (Employee e : employees) {
            e.showDetails(); // Correct method runs depending on type
        }
    }
}
