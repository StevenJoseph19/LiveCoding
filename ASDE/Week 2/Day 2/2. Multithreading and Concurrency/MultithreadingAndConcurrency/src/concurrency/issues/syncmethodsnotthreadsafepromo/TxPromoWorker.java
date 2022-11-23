package concurrency.issues.syncmethodsnotthreadsafepromo;


import concurrency.issues.syncmethodswithwithdrawal.BankAccount;
import concurrency.issues.syncmethodswithwithdrawal.TxWorker;

public class TxPromoWorker extends TxWorker {
    protected BankAccount account;
    protected char txType; // ‘w’ -> withdrawal, ‘d’ -> deposit
    protected int amt;

    public TxPromoWorker(BankAccount account, char txType, int amt) {
        super(account, txType, amt);
        this.account = account;
        this.txType = txType;
        this.amt = amt;
    }

    public void run() {

        if (txType == 'w') account.withdrawal(amt);
        else if (txType == 'd') {

                account.deposit(amt);
                if (account.getBalance() > 500) {

                    int bonus = ((int) ((account.getBalance() - 500) * 0.1));
                    account.deposit(bonus);

                }
            }
    }
}
