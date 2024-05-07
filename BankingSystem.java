import java.util.HashMap;
import java.util.ArrayList;

class BankingSystem {
    HashMap<Integer, BankAccount> registeredAccounts = new HashMap<>();
    HashMap<Integer, ArrayList<Transaction>> transactions = new HashMap<>();

    // function to create bank account
    public void createAccount(BankAccount a) {
        try {
            if (registeredAccounts.containsKey(a.getAccountNum())) {
                throw new BankException("Bank account with account number " + a.getAccountNum() + " already exists!");
            }
            registeredAccounts.put(a.getAccountNum(), a);
            System.out.println("Bank account created successfully!!");
        } catch (BankException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // function to deposit
    public void deposit(int accountNum, int balance) {
        try {
            if (!registeredAccounts.containsKey(accountNum)) {
                throw new BankException("Bank account with account number " + accountNum + " doesn't exist!");
            }
            if (balance < 0) {
                throw new BankException("You cannot deposit -ve value!!");
            }
            BankAccount a = registeredAccounts.get(accountNum);
            a.setBalance(a.getBalance() + balance);
            transactions.put(a.getAccountNum(), a.addTransaction("deposited", balance));
            System.out.println("Deposited successfully!!");
        } catch (BankException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // withdrawing function
    public void withdraw(int accountNum, int balance) {
        try {
            if (!registeredAccounts.containsKey(accountNum)) {
                throw new BankException("Bank account with account number " + accountNum + " doesn't exist!");
            }
            BankAccount a = registeredAccounts.get(accountNum);
            if (a.getBalance() - balance < 0) {
                throw new BankException("Your account doesn't have enough money!");
            }
            a.setBalance(a.getBalance() - balance);
            transactions.put(a.getAccountNum(), a.addTransaction("withdrawn", balance));
            System.out.println("Withdrawn successfully!!");

        } catch (BankException e) {
            System.out.println(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // transfer funnction
    public void transfer(int fromAccNum, int toAccNum, int balance) {
        try {
            if (!registeredAccounts.containsKey(fromAccNum) || !registeredAccounts.containsKey(toAccNum)) {
                throw new BankException("Some error occured..");
            }
            withdraw(fromAccNum, balance);
            deposit(toAccNum, balance);
            System.out.println("Transferred successfully!!");
        } catch (BankException e) {
            System.out.println(e);
        }
    }

    //display transactions of a specific account
    public void displayTransactionInfo(int accNum) {
        try {
            if (!registeredAccounts.containsKey(accNum)) {
                throw new BankException("Bank account with account number " + accNum + " doesn't exist!");
            }
            BankAccount a = registeredAccounts.get(accNum);
            System.out.println("Transactoins of account number " + accNum + " are mentioned below:");
            a.displayTransaction();
          } catch (BankException e) {
                System.out.println(e);
        }
    }

    //displays current balance of a account 
    public void currentBalance(int accNum) {
        try {
            if (!registeredAccounts.containsKey(accNum)) {
                throw new BankException("Bank account with account number " + accNum + " doesn't exist!");
            }
            BankAccount a = registeredAccounts.get(accNum);
            System.out.println("Account balance: " + a.getBalance());
        } catch (BankException e) {
            System.out.println(e);
        }
    }
}
