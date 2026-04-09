class SimpleCounter {
    int count = 0;

    void increment() {
        count = count + 1;
    }
}

class CounterWorker extends Thread {
    SimpleCounter counter;

    CounterWorker(SimpleCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Thread8_1 {
    public static void main(String[] args) throws Exception {
        SimpleCounter counter = new SimpleCounter();

        CounterWorker t1 = new CounterWorker(counter);
        CounterWorker t2 = new CounterWorker(counter);
        CounterWorker t3 = new CounterWorker(counter);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final Count: " + counter.count);
    }
}