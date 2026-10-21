class Account {
    private int balance = 1000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Balance: " + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
        System.out.println("Balance: " + balance);
    }
}

public class RunnableBank {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        Runnable depositTask = () -> account.deposit(500);
        Runnable withdrawTask = () -> account.withdraw(300);

        Thread t1 = new Thread(depositTask);
        Thread t2 = new Thread(withdrawTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
