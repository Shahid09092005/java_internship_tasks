import java.util.Scanner;
class BankingSystem {
    float balance = 0;
    String name;
    int pin;
    Scanner sc = new Scanner(System.in); //  Only one Scanner object for entire class

    //User details
    public void Details() {
        System.out.print("Enter you name: ");
        name = sc.nextLine();
        System.out.print("Enter you pin number: ");
        pin = sc.nextInt();

        if (checkPin(pin)) { // checking pin
            options(); // ✅ Go to menu
        } else {
            System.out.println("Enter correct 4 digit pin number");
        }
    }

    // Check pin length
    public static boolean checkPin(int pin) {
        if (String.valueOf(pin).length() == 4) {
            return true;
        } else {
            return false;
        }
    }

    // Options menu
    public void options() {
        int user_choice; // Moved choice here so it updates every loop

        //  Do-while loop to repeat until Exit
        do {
            System.out.println("\n\t\t\t\t\t\t\tOPTIONS");
            System.out.println("1 for Deposit\n2 for Withdraw\n3 for check balance\n4 for Exit\n");
            System.out.print("Enter your preference: ");
            user_choice = sc.nextInt();

            switch (user_choice) {
                case 1:
                    Deposit();
                    break; 
                case 2:
                    Withdraw();
                    break;
                case 3:
                    CheckBalance();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Enter a correct option!");
            }
        } while (user_choice != 4);
    }

    //Deposit money
    public void Deposit() {
        System.out.println("Enter the amount you want to deposit: ");
        float amount = sc.nextFloat();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successfully");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    //Withdraw money
    public void Withdraw() {
        System.out.println("Enter amount to withdraw: ");
        float amount = sc.nextFloat();
        if (balance > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw Successfully!!");
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    //Check balance
    public void CheckBalance() {
        System.out.println("Available Amount is " + balance);
    }
}

public class atm {
    public static void main(String[] args) {
        BankingSystem user = new BankingSystem();
        System.out.println("\t\t\t\t\t\t\tATM");
        user.Details();
    }
}
