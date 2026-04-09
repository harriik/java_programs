import java.util.*;

class EvenNumberWorker extends Thread {
    List<Integer> numbers;
    EvenNumberWorker(List<Integer> numbers) { this.numbers = numbers; }

    public void run() {
        for (int n : numbers)
            if (n % 2 == 0)
                System.out.println("Even Number: " + n);
    }
}

class OddNumberWorker extends Thread {
    List<Integer> numbers;
    OddNumberWorker(List<Integer> numbers) { this.numbers = numbers; }

    public void run() {
        for (int n : numbers)
            if (n % 2 != 0)
                System.out.println("Odd Number: " + n);
    }
}

public class Thread7 {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(5, 6, 9, 10, 15, 20);

        new EvenNumberWorker(values).start();
        new OddNumberWorker(values).start();
    }
}