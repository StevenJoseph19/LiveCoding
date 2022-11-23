package concurrency.issues.syncmethodsthreadsafepromo;

public class BankAccount {
    private int balance;

    public BankAccount(int startBalance) {
        balance = startBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }


    public void withdrawal(int amount) {
        balance -= amount;

    }
}
