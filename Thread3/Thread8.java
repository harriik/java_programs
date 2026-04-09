class SharedCounter {
    int count = 0;

    void increment() {
        count = count + 1;
    }
}

class IncrementTask extends Thread {
    SharedCounter counter;

    IncrementTask(SharedCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Thread8 {
    public static void main(String[] args) throws Exception {
        SharedCounter counter = new SharedCounter();

        IncrementTask t1 = new IncrementTask(counter);
        IncrementTask t2 = new IncrementTask(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter Value: " + counter.count);
    }
}