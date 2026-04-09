import java.util.*;

class AscendingOrder extends Thread {
    List<Integer> data;
    AscendingOrder(List<Integer> data) { this.data = data; }

    public void run() {
        Collections.sort(data);
        System.out.println("Ascending Order: " + data);
    }
}

class DescendingOrder extends Thread {
    List<Integer> data;
    DescendingOrder(List<Integer> data) { this.data = data; }

    public void run() {
        Collections.sort(data, Collections.reverseOrder());
        System.out.println("Descending Order: " + data);
    }
}

public class Thread6 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(8, 3, 9, 4, 2);

        new AscendingOrder(numbers).start();
        new DescendingOrder(numbers).start();
    }
}