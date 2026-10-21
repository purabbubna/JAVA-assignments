class NumberTask implements Runnable {
    private int start;

    NumberTask(int start) {
        this.start = start;
    }

    public void run() {
        for (int i = start; i < start + 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new NumberTask(1), "Thread-1");
        Thread t2 = new Thread(new NumberTask(6), "Thread-2");
        Thread t3 = new Thread(new NumberTask(11), "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Execution completed");
    }
}
