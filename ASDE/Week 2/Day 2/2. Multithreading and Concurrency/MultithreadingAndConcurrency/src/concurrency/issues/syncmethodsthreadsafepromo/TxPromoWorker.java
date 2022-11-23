package concurrency.issues.syncmethodsthreadsafepromo;



public class TxPromoWorker extends TxWorker {
    protected BankAccount account;
    protected char txType; // �w� -> withdrawal, �d� -> deposit
    protected int amt;

    public TxPromoWorker(BankAccount account, char txType, int amt) {
        super(account, txType, amt);
        this.account = account;
        this.txType = txType;
        this.amt = amt;
    }

    public void run() {
        synchronized (account) {


        if (txType == 'w') account.withdrawal(amt);
        else if (txType == 'd') {
//            synchronized (account) {
                account.deposit(amt);
                if (account.getBalance() > 500) {

                    int bonus = ((int) ((account.getBalance() - 500) * 0.1));
                    account.deposit(bonus);

                }
            }
        }
    }
}
