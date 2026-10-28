
package bank;

class BankAccount {
    private final int accountNumber;
    private double balance;

    private static int accountCount = 0;
    private static final double MIN_BALANCE = 0.0;

    BankAccount(int accountNumber, double balance) {
        if (accountNumber <= 0 || balance < MIN_BALANCE)
            throw new IllegalArgumentException("Invalid account details");

        this.accountNumber = accountNumber;
        this.balance = balance;
        accountCount++;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public final void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit must be positive");

        balance += amount;
    }

    public void withdraw(double amount)
            throws InsufficientFundsException {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive");

        if (amount > balance)
            throw new InsufficientFundsException("Insufficient balance");

        balance -= amount;
    }

    public void display() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class AccountDemo {
    public static void main(String[] args) {
        BankAccount a = null;

        try {
            a = new BankAccount(101, 5000);
            a.deposit(1000);
            a.withdraw(2000);
            a.withdraw(10000);
        } catch (InsufficientFundsException e) {
            System.out.println("Bank error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        if (a != null)
            a.display();

        System.out.println(
            "Total accounts: " + BankAccount.getAccountCount()
        );
    }
}

