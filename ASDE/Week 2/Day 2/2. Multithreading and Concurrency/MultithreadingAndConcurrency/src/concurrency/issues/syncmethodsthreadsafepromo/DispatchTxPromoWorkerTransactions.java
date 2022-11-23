package concurrency.issues.syncmethodsthreadsafepromo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class DispatchTxPromoWorkerTransactions {

    public static void main(String[] args) {
//        ExecutorService es = Executors.FixedThreadPool(5);
        ExecutorService es = Executors.newSingleThreadExecutor();
        BankAccount account = new BankAccount(450);
        // Retrieve TxPromoWorker instances

        int startBalance = account.getBalance();

        TxWorker[] workers = {new TxPromoWorker(account, 'd', 150), new TxPromoWorker(account, 'w', 300)};

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
