class NumberThread extends Thread {
    private int start;

    NumberThread(int start) {
        this.start = start;
    }

    public void run() {
        for (int i = start; i < start + 5; i++) {
            System.out.println(getName() + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        NumberThread t1 = new NumberThread(1);
        NumberThread t2 = new NumberThread(6);
        NumberThread t3 = new NumberThread(11);

        System.out.println(t1.getState());

        t1.start();
        t2.start();
        t3.start();

        System.out.println(t1.getState());

        t1.join();
        t2.join();
        t3.join();

        System.out.println(t1.getState());
        System.out.println("All threads completed");
    }
}
