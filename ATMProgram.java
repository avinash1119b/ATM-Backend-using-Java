import java.util.Scanner;

public class ATMProgram {
    private static double balance = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Welcome to the ATM\nPlease enter your PIN: ");
        int pin = scanner.nextInt();

        if (validatePIN(pin)) {
            showMenu();
            int choice;

            do {
                System.out.print("Enter your choice (1-5): ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        miniStatement();
                        break;
                    case 5:
                        exit();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Invalid PIN. Exiting...");
        }
    }

    private static boolean validatePIN(int enteredPIN) {
        int correctPIN = 1234; 
        return enteredPIN == correctPIN;
    }

    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Mini Statement");
        System.out.println("5. Exit");
    }

    private static void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void miniStatement() {
        System.out.println("Mini Statement:");
        System.out.println("Transaction: Balance Inquiry");
        System.out.println("Date/Time: <insert date and time>");
        System.out.println("Balance: $" + balance);
    }

    private static void exit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
    }
}