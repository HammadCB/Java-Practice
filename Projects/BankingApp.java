package Projects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.math.BigDecimal;

/**
 * Console Banking System (single-file, in-memory)
 * Features:
 * - Main menu: Login User, Login Admin, Exit
 * - Admin (hardcoded creds): create account, list/search accounts, view logs (per account or all), suspend/unsuspend, delete
 * - User login via Account No + 4-digit PIN (3 attempts)
 * - User actions: deposit, withdraw, transfer, balance, transaction logs
 * - Per-account transaction logs with timestamps
 * - Daily withdrawal/deposit limits
 *
 * Note: Data is in-memory only (lost on exit). For persistence, add file/DB later.
 */

class Transaction {
    enum Type { CREATE, DEPOSIT, WITHDRAWAL, TRANSFER_IN, TRANSFER_OUT }

    private final LocalDateTime time;
    private final Type type;
    private final BigDecimal amount;
    private final BigDecimal balanceAfter;
    private final String note;

    Transaction(Type type, BigDecimal amount, BigDecimal balanceAfter, String note) {
        this.time = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.note = note;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sign = (type == Type.WITHDRAWAL || type == Type.TRANSFER_OUT) ? "-" : "+";
        return String.format("%s | %-12s | %s%s | Bal: %s | %s",
                fmt.format(time), type, sign, amount, balanceAfter, note == null ? "" : note);
    }
}

class BankAccount {
    private final int accountNumber;
    private String holderName;
    private int pin; // 4-digit
    private BigDecimal balance;
    private boolean suspended = false;
    private final List<Transaction> logs = new ArrayList<>();

    private BigDecimal todayDeposits = BigDecimal.ZERO;
    private BigDecimal todayWithdrawals = BigDecimal.ZERO;
    private LocalDateTime lastResetDate = LocalDateTime.now();

    private static final BigDecimal DAILY_DEPOSIT_LIMIT = new BigDecimal("10000");
    private static final BigDecimal DAILY_WITHDRAW_LIMIT = new BigDecimal("5000");

    BankAccount(int accountNumber, String holderName, int pin, BigDecimal initialDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.pin = pin;
        this.balance = BigDecimal.ZERO;
        if (initialDeposit.compareTo(BigDecimal.ZERO) > 0) {
            deposit(initialDeposit, "Initial deposit");
        } else {
            logs.add(new Transaction(Transaction.Type.CREATE, BigDecimal.ZERO, balance, "Account created"));
        }
    }

    private void resetDailyLimitsIfNeeded() {
        if (!lastResetDate.toLocalDate().equals(LocalDateTime.now().toLocalDate())) {
            todayDeposits = BigDecimal.ZERO;
            todayWithdrawals = BigDecimal.ZERO;
            lastResetDate = LocalDateTime.now();
        }
    }

    int getAccountNumber() { return accountNumber; }
    String getHolderName() { return holderName; }
    void setHolderName(String holderName) { this.holderName = holderName; }
    boolean isSuspended() { return suspended; }
    void setSuspended(boolean suspended) { this.suspended = suspended; }
    BigDecimal getBalance() { return balance; }

    boolean checkPin(int pin) { return this.pin == pin; }
    void setPin(int newPin) { this.pin = newPin; }

    List<Transaction> getLogs() { return Collections.unmodifiableList(logs); }

    boolean deposit(BigDecimal amount, String note) {
        resetDailyLimitsIfNeeded();
        if (amount.compareTo(BigDecimal.ZERO) <= 0) return false;
        if (todayDeposits.add(amount).compareTo(DAILY_DEPOSIT_LIMIT) > 0) {
            return false;
        }
        balance = balance.add(amount);
        todayDeposits = todayDeposits.add(amount);
        logs.add(new Transaction(Transaction.Type.DEPOSIT, amount, balance, note));
        return true;
    }

    boolean withdraw(BigDecimal amount, String note) {
        resetDailyLimitsIfNeeded();
        if (amount.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(balance) > 0) return false;
        if (todayWithdrawals.add(amount).compareTo(DAILY_WITHDRAW_LIMIT) > 0) {
            return false;
        }
        balance = balance.subtract(amount);
        todayWithdrawals = todayWithdrawals.add(amount);
        logs.add(new Transaction(Transaction.Type.WITHDRAWAL, amount, balance, note));
        return true;
    }

    boolean transferTo(BankAccount target, BigDecimal amount) {
        if (this.withdraw(amount, "Transfer to " + target.getAccountNumber())) {
            target.deposit(amount, "Transfer from " + this.getAccountNumber());
            logs.add(new Transaction(Transaction.Type.TRANSFER_OUT, amount, balance, "To Acc " + target.getAccountNumber()));
            target.logs.add(new Transaction(Transaction.Type.TRANSFER_IN, amount, target.getBalance(), "From Acc " + this.getAccountNumber()));
            return true;
        }
        return false;
    }
}

public class BankingApp {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    private static final Scanner sc = new Scanner(System.in);
    private static final Map<Integer, BankAccount> accounts = new HashMap<>();
    private static int nextAccountNumber = 10001;

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            int choice = readInt("Choose an option: ");
            switch (choice) {
                case 1 -> userLogin();
                case 2 -> adminLogin();
                case 0 -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice. Try again.\n");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n===== BANKING SYSTEM =====");
        System.out.println("1) Login as User");
        System.out.println("2) Login as Admin");
        System.out.println("0) Exit");
    }

    private static void userMenu(BankAccount acc) {
        while (true) {
            System.out.printf("\n-- User Menu (Acc #%d | %s) --\n", acc.getAccountNumber(), acc.getHolderName());
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Check Balance");
            System.out.println("4) Transaction Logs");
            System.out.println("5) Transfer to another account");
            System.out.println("0) Logout");
            int c = readInt("Choose: ");
            switch (c) {
                case 1 -> doDeposit(acc);
                case 2 -> doWithdraw(acc);
                case 3 -> System.out.printf("Current Balance: %s\n", acc.getBalance());
                case 4 -> printLogs(acc);
                case 5 -> doTransfer(acc);
                case 0 -> { System.out.println("Logged out.\n"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n-- Admin Menu --");
            System.out.println("1) Register new user account");
            System.out.println("2) List all accounts");
            System.out.println("3) Search account by number");
            System.out.println("4) View transaction logs for a specific account");
            System.out.println("5) View transaction logs for ALL accounts");
            System.out.println("6) Suspend/Unsuspend an account");
            System.out.println("7) Delete an account");
            System.out.println("0) Logout");
            int c = readInt("Choose: ");
            switch (c) {
                case 1 -> registerAccount();
                case 2 -> listAllAccounts();
                case 3 -> searchAccountByNumber();
                case 4 -> adminViewLogsForOne();
                case 5 -> adminViewLogsForAll();
                case 6 -> toggleSuspend();
                case 7 -> deleteAccount();
                case 0 -> { System.out.println("Admin logged out.\n"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void userLogin() {
        int accNo = readInt("Enter Account Number: ");
        BankAccount acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("No account found with that number.");
            return;
        }
        if (acc.isSuspended()) {
            System.out.println("This account is suspended. Contact admin.");
            return;
        }
        int attempts = 3;
        while (attempts-- > 0) {
            int pin = readInt("Enter 4-digit PIN: ");
            if (pin >= 0 && pin <= 9999 && acc.checkPin(pin)) {
                userMenu(acc);
                return;
            } else {
                System.out.printf("Incorrect PIN. Attempts left: %d\n", attempts);
            }
        }
        System.out.println("Too many wrong attempts. Account suspended.");
        acc.setSuspended(true);
    }

    private static void adminLogin() {
        String u = readLine("Admin Username: ");
        String p = readLine("Admin Password: ");
        if (ADMIN_USERNAME.equals(u) && ADMIN_PASSWORD.equals(p)) {
            adminMenu();
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }

    private static void registerAccount() {
        String name = readLine("Holder Name: ");
        int pin;
        while (true) {
            pin = readInt("Set 4-digit PIN: ");
            if (pin >= 0 && pin <= 9999) break;
            System.out.println("PIN must be a 4-digit number (0000-9999).");
        }
        BigDecimal init = readBigDecimal("Initial Deposit (>= 0): ");
        if (init.compareTo(BigDecimal.ZERO) < 0) init = BigDecimal.ZERO;
        int accNo = nextAccountNumber++;
        BankAccount acc = new BankAccount(accNo, name, pin, init);
        accounts.put(accNo, acc);
        System.out.printf("Account created successfully! Account No: %d | Holder: %s | Balance: %s\n",
                accNo, name, acc.getBalance());
    }

    private static void listAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        System.out.println("\n-- All Accounts --");
        accounts.values().stream()
                .sorted(Comparator.comparingInt(BankAccount::getAccountNumber))
                .forEach(acc -> System.out.printf("Acc #%d | %-20s | Bal: %s | %s\n",
                        acc.getAccountNumber(), acc.getHolderName(), acc.getBalance(),
                        acc.isSuspended() ? "SUSPENDED" : "ACTIVE"));
    }

    private static void searchAccountByNumber() {
        int accNo = readInt("Enter Account Number: ");
        BankAccount acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Not found.");
            return;
        }
        System.out.printf("Found -> Acc #%d | %s | Bal: %s | %s\n",
                acc.getAccountNumber(), acc.getHolderName(), acc.getBalance(),
                acc.isSuspended() ? "SUSPENDED" : "ACTIVE");
    }

    private static void adminViewLogsForOne() {
        int accNo = readInt("Enter Account Number: ");
        BankAccount acc = accounts.get(accNo);
        if (acc == null) { System.out.println("Not found."); return; }
        printLogs(acc);
    }

    private static void adminViewLogsForAll() {
        if (accounts.isEmpty()) { System.out.println("No accounts."); return; }
        System.out.println("\n-- Logs for ALL Accounts --");
        accounts.values().stream()
                .sorted(Comparator.comparingInt(BankAccount::getAccountNumber))
                .forEach(BankingApp::printLogs);
    }

    private static void toggleSuspend() {
        int accNo = readInt("Enter Account Number: ");
        BankAccount acc = accounts.get(accNo);
        if (acc == null) { System.out.println("Not found."); return; }
        acc.setSuspended(!acc.isSuspended());
        System.out.printf("Account %d is now %s.\n", accNo, acc.isSuspended() ? "SUSPENDED" : "ACTIVE");
    }

    private static void deleteAccount() {
        int accNo = readInt("Enter Account Number to DELETE: ");
        BankAccount acc = accounts.remove(accNo);
        if (acc == null) {
            System.out.println("Not found.");
        } else {
            System.out.printf("Account %d deleted.\n", accNo);
        }
    }

    private static void doDeposit(BankAccount acc) {
        BigDecimal amt = readBigDecimal("Deposit amount: ");
        if (amt.compareTo(BigDecimal.ZERO) <= 0) { System.out.println("Amount must be > 0."); return; }
        if (acc.isSuspended()) { System.out.println("Account suspended."); return; }
        if (acc.deposit(amt, "User deposit")) {
            System.out.printf("Deposited %s successfully. New balance: %s\n", amt, acc.getBalance());
        } else {
            System.out.println("Deposit failed (may exceed daily limit).");
        }
    }

    private static void doWithdraw(BankAccount acc) {
        BigDecimal amt = readBigDecimal("Withdraw amount: ");
        if (amt.compareTo(BigDecimal.ZERO) <= 0) { System.out.println("Amount must be > 0."); return; }
        if (acc.isSuspended()) { System.out.println("Account suspended."); return; }
        if (acc.withdraw(amt, "User withdrawal")) {
            System.out.printf("Withdrawn %s successfully. New balance: %s\n", amt, acc.getBalance());
        } else {
            System.out.println("Insufficient funds, invalid amount, or daily limit exceeded.");
        }
    }

    private static void doTransfer(BankAccount acc) {
        int targetNo = readInt("Enter target Account Number: ");
        BankAccount target = accounts.get(targetNo);
        if (target == null) { System.out.println("Target account not found."); return; }
        if (target.isSuspended()) { System.out.println("Target account is suspended."); return; }
        BigDecimal amt = readBigDecimal("Enter amount to transfer: ");
        if (acc.transferTo(target, amt)) {
            System.out.printf("Transferred %s from Acc #%d to Acc #%d successfully. New balance: %s\n",
                    amt, acc.getAccountNumber(), target.getAccountNumber(), acc.getBalance());
        } else {
            System.out.println("Transfer failed (insufficient funds or daily limit exceeded).");
        }
    }

    private static void printLogs(BankAccount acc) {
        System.out.printf("\n[Logs] Account #%d | %s\n", acc.getAccountNumber(), acc.getHolderName());
        List<Transaction> logs = acc.getLogs();
        if (logs.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        for (Transaction t : logs) {
            System.out.println(t);
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = sc.nextLine().trim();
                return Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static BigDecimal readBigDecimal(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = sc.nextLine().trim();
                return new BigDecimal(line);
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}
