package CH_3;

import java.util.Scanner;

class BankAccount {
    String name;
    double balance;

    // Constructor
    BankAccount(String n, double b) {
        name = n;
        balance = b;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void showBalance() {
        System.out.println("Account Holder: " + name + " | Balance: " + balance);
    }
}

public class BankAccountApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String n = sc.nextLine();

        System.out.print("Enter opening balance: ");
        double b = sc.nextDouble();

        BankAccount acc = new BankAccount(n, b);

        acc.showBalance();

        System.out.print("Enter amount to deposit: ");
        double dep = sc.nextDouble();
        acc.deposit(dep);

        System.out.print("Enter amount to withdraw: ");
        double wd = sc.nextDouble();
        acc.withdraw(wd);

        acc.showBalance();

        sc.close();
    }
}
