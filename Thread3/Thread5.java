import java.util.Random;

class DetermineNum extends Thread {
    int value;

    DetermineNum(int value) {
        this.value = value;
    }

    public void run() {
        if (value < 0)
            System.out.println(value + " is Negative");
        else if (value % 2 == 0)
            System.out.println(value + " is Positive Even");
        else
            System.out.println(value + " is Positive Odd");
    }
}

public class Thread5 {
    public static void main(String[] args) {
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            int num = rand.nextInt(11) - 5;
            new DetermineNum(num).start();
        }
    }
}