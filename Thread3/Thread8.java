class Counter {
    int count = 0;
    void inc() {
        count = count + 1;
    }
    int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    Counter c;

    CounterThread(Counter c) {
        this.c = c;
    }

    public void run() {
        for (int i = 0; i < 1000; i++)
            c.inc();
    }
}

public class Thread8 {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        CounterThread t1 = new CounterThread(c);
        CounterThread t2 = new CounterThread(c);

        t1.start(); t2.start();

        t1.join(); t2.join();

        System.out.println("Final Count: " + c.count);
    }
}