import java.util.ArrayList;
class BankAccount{
   private int accountNum;
   private int balance;
   private ArrayList<Transaction> temp = new ArrayList<>();
   private int count=0;
    
    public BankAccount(int accountNum, int balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public int getAccountNum() {
        return accountNum;
    }
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance){
        this.balance = balance;
    }

    public ArrayList<Transaction> addTransaction(String transaction_type,int balance){
        count+=1;
        Transaction t1 = new Transaction( count ,transaction_type, balance);
        temp.add(t1);
        return temp;
    }

    public void  displayTransaction(){
          for(Transaction t:temp){
             System.out.println("Transaction id: "+t.getTransaction_id()+", Transaction type: "+t.getTransaction_type()+", balance: "+t.getAmount());
          }
    }
}
