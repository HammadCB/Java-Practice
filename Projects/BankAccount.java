package Projects;


import java.util.Scanner;
public class BankAccount {
     int accountNumber;
    private double balance;
    
    BankAccount(int accNo, double bal){
        accountNumber = accNo;
        balance = bal;
    }
    
    void setBalance(double b){
        if(b>0){
            balance = b;
        }
        else{
            System.out.println("Balance cannot be negative");
        }
    }
    double getBalance(){
        return balance;
    }
    
    void depositAmout(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited: "+amount);
        }
        else{
            System.out.println("Invalid deposit amount");
        }   
    }
    
    void withdrawAmmount(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn: "+amount);
        }
        else{
            System.out.println("Insufficient amount");
        }
    }
    
    void displayBalance(){
        System.out.println("Current Balance: "+balance);
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       System.out.print("Enter Account Number: ");
       int accNo = sc.nextInt();
       System.out.print("Enter the Balance: ");
       double bal = sc.nextDouble();
       
       BankAccount account1 = new BankAccount(accNo,bal);
       
        System.out.print("Enter deposit Amount: ");
        double dep = sc.nextDouble();
        account1.depositAmout(dep);
        account1.displayBalance();
        
        System.out.print("Enter Withdraw Amount: ");
        double withd = sc.nextDouble();
        account1.withdrawAmmount(withd);
        account1.displayBalance();  
        sc.close();
    }    
}