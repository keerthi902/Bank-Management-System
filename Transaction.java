//transaction class
class Transaction{
    int transaction_id;
    String transaction_type;
    int amount;

    public Transaction(int transaction_id, String transaction_type, int amount) {
        this.transaction_id = transaction_id;
        this.transaction_type = transaction_type;
        this.amount = amount;
    }

    public int getTransaction_id() {
        return transaction_id;
    }
    public String getTransaction_type() {
        return transaction_type;
    }
    public int getAmount() {
        return amount;
    }    
}
