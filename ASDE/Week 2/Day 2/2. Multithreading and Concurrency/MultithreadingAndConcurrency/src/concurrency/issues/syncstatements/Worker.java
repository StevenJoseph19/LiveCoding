package concurrency.issues.syncstatements;

public class Worker implements Runnable {
    private BankAccount account;

    public Worker(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {

            synchronized (account) {
                account.deposit(10);
            }


        }
    }
}
