class MyThread extends Thread {
    MyThread() {
        super("Worker Thread");
        start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());
        }
    }
}

public class Thread3 {
    public static void main(String[] args) {
        new MyThread();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Execution");
        }
    }
}