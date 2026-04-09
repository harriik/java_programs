import java.util.Scanner;

class SharedCounter {
    int count = 0;

    void increment() {
        count = count + 1;
    }
}

class IncrementWorker extends Thread {
    SharedCounter counter;
    int times;

    IncrementWorker(SharedCounter counter, int times) {
        this.counter = counter;
        this.times = times;
    }

    public void run() {
        for (int i = 0; i < times; i++) {
            counter.increment();
        }
    }
}

public class Thread8_2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of threads: ");
        int n = sc.nextInt();

        System.out.print("Enter increments per thread: ");
        int inc = sc.nextInt();

        SharedCounter counter = new SharedCounter();
        IncrementWorker[] threads = new IncrementWorker[n];

        for (int i = 0; i < n; i++) {
            threads[i] = new IncrementWorker(counter, inc);
            threads[i].start();
        }

        for (int i = 0; i < n; i++) {
            threads[i].join();
        }

        System.out.println("Expected: " + (n * inc));
        System.out.println("Actual: " + counter.count);
    }
}