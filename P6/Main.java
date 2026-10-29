
class BankAccount {
    private static String bankName = "ABC Bank";
    private static int totalAccounts = 0;
    private final int accountNumber;
    private double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        if (balance < 0) {
            throw new IllegalArgumentException(
                "Balance cannot be negative");
        }
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException(
                "Invalid amount or insufficient balance");
        }
        balance -= amount;
    }

    public void display() {
        System.out.println("Bank: " + bankName);
        System.out.println("Account: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public static void showTotalAccounts() {
        System.out.println("Total accounts: " + totalAccounts);
    }
}

public class Practical6 {
    public static void main(String[] args) {
        try {
            BankAccount a = new BankAccount(101, 5000);
            a.deposit(1000);
            a.withdraw(500);
            a.display();

            BankAccount.showTotalAccounts();

            a.withdraw(10000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction process completed.");
        }
    }
}

