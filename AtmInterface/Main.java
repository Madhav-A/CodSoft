import java.util.InputMismatchException;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double deposit(double amount) {
        this.balance += amount;
        return this.balance;
    }

    public boolean withdraw(double amount) {
        if (amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public double checkBalance() {
        return this.balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = getValidAmount();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: " + account.checkBalance());
        }
        else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = getValidAmount();
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: " + account.checkBalance());
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + account.checkBalance());
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = getValidChoice();
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private double getValidAmount() {
        while (true) {
            try {
                return scanner.nextDouble();
            }
            catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid amount: ");
                scanner.next();
            }
        }
    }

    private int getValidChoice() {
        while (true) {
            try {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
                else {
                    System.out.print("Invalid choice. Please enter a number between 1 and 4: ");
                }
            }
            catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid choice: ");
                scanner.next();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.run();
    }
}
