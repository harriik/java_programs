class NamePrinterThread extends Thread {
    public void run() {
        try {
            System.out.println("Harikesan D J - Thread Method");
            Thread.sleep(500);
        } catch (InterruptedException e) {}
    }
}

class NamePrinterTask implements Runnable {
    public void run() {
        try {
            System.out.println("Harikesan D J - Runnable Method");
            Thread.sleep(500);
        } catch (InterruptedException e) {}
    }
}

public class Thread1 {
    public static void main(String[] args) {
        NamePrinterThread t1 = new NamePrinterThread();
        Thread t2 = new Thread(new NamePrinterTask());

        t1.start();
        t2.start();
    }
}