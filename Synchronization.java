class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

  
    public synchronized int getCount() {
        return count;
    }
}

class Worker extends Thread {
    private Counter counter;

    public Worker(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Worker thread1 = new Worker(counter);
        Worker thread2 = new Worker(counter);

        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        // Print the final count
        System.out.println("Final count: " + counter.getCount());
    }
}
