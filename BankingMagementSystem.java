import java.util.Scanner;
public class BankingMagementSystem {
   public static void main(String[] args) {
    BankingSystem bankingSystem = new BankingSystem();

    // BankAccount account1 = new BankAccount(1, 1000);
    // BankAccount account2 = new BankAccount(2, 2000);

    // bankingSystem.createAccount(account1);
    // bankingSystem.createAccount(account2);

    // bankingSystem.deposit(1, 500);

    // bankingSystem.withdraw(2, 300);

    // bankingSystem.transfer(1, 2, 200);

    // bankingSystem.displayTransactionInfo(1);
    // bankingSystem.displayTransactionInfo(2);

    // bankingSystem.currentBalance(1);
    // bankingSystem.currentBalance(2);

        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("****************Welcome to the Banking System *****************");
            System.out.println("1. Create Account\n" +
                    "2. Deposit\n" +
                    "3. Withdraw\n" +
                    "4. Transfer\n" +
                    "5. Display Transaction Info\n" +
                    "6. Check Current Balance\n" +
                    "7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNum = sc.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    int initBalance = sc.nextInt();
                    BankAccount newAcc = new BankAccount(accNum, initBalance);
                    bankingSystem.createAccount(newAcc);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    int depositAccNum = sc.nextInt();
                    System.out.print("Enter Deposit Amount: ");
                    int depositAmount = sc.nextInt();
                    bankingSystem.deposit(depositAccNum, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int withdrawAccNum = sc.nextInt();
                    System.out.print("Enter Withdrawal Amount: ");
                    int withdrawAmount = sc.nextInt();
                    bankingSystem.withdraw(withdrawAccNum, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter Source Account Number: ");
                    int fromAccNum = sc.nextInt();
                    System.out.print("Enter Destination Account Number: ");
                    int toAccNum = sc.nextInt();
                    System.out.print("Enter Transfer Amount: ");
                    int transferAmount = sc.nextInt();
                    bankingSystem.transfer(fromAccNum, toAccNum, transferAmount);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    int displayAccNum = sc.nextInt();
                    bankingSystem.displayTransactionInfo(displayAccNum);
                    break;
                case 6:
                    System.out.print("Enter Account Number: ");
                    int balanceAccNum = sc.nextInt();
                    bankingSystem.currentBalance(balanceAccNum);
                    break;
                case 7:
                    flag = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (flag);
        sc.close();
    }

}
