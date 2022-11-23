package concurrency.issues.syncmethodswithwithdrawal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DispatchTxWorkerTransactions {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);

        BankAccount account = new BankAccount(0);
        account.deposit(100);

        int startBalance = account.getBalance();


        // Retrieve TxWorker instances
        TxWorker[] workers = {new TxWorker(account, 'w', 20), new TxWorker(account, 'd', 1100),
                new TxWorker(account, 'd', 200), new TxWorker(account, 'w', 200), new TxWorker(account, 'w', 190)};
        for (TxWorker worker : workers)
            es.submit(worker);

        // Shutdown es and wait
        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int endBalance = account.getBalance();
        System.out.println("End Balance : " + endBalance + "  Start Balance :  " + startBalance);
    }

}
