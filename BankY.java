import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0; // Initial balance is set to 0.0
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully. Current Balance: " + balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully. Remaining Balance: " + balance);
        }
    }

    public void transfer(BankAccount otherAccount, double amount) {
        if (amount <= balance) {
            this.withdraw(amount); // Withdraw from this account
            otherAccount.deposit(amount); // Deposit into the other account
            System.out.println("Transfer successful. New Balance: " + this.balance);
        } else {
            System.out.println("Insufficient balance. Transfer failed.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber +
                ", Account Holder: " + accountHolder +
                ", Balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to BankY!");
        System.out.print("Enter your account number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter your name: ");
        String accountHolder = sc.nextLine();

        BankAccount userAccount = new BankAccount(accountNumber, accountHolder);

        System.out.println("\nAccount created successfully!");
        userAccount.displayAccountDetails();

        // Example usage:
        userAccount.deposit(1000);
        userAccount.withdraw(200);
        userAccount.displayAccountDetails();

        // Create another account for transfer demonstration
        BankAccount otherAccount = new BankAccount("987654", "Alice");
        userAccount.transfer(otherAccount, 300);
        userAccount.displayAccountDetails();
        otherAccount.displayAccountDetails();
    }
}
