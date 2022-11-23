package concurrency.issues.syncmethodsthreadsafepromo;

public class TxWorker implements Runnable {
    protected BankAccount account;

    protected char txType; // ‘w’ -> withdrawal, ‘d’ -> deposit
    protected int amt;



    public TxWorker(BankAccount account, char txType, int amt) {
        super();
        this.account = account;
        this.txType = txType;
        this.amt = amt;
    }

    public void run() {

        synchronized (account) {

            if (txType == 'w')
                account.withdrawal(amt);
            else if (txType == 'd')
                account.deposit(amt);


        }


    }
}
