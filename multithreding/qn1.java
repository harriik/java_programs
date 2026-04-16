class MyThread extends Thread {
    String name;
    int delay;
    public MyThread(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }
    public void run() {
        for(int i=0;i<5;i++){
            try {
                System.out.println(name);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class qn1{
    public static void main(String[] args) throws Exception{
        MyThread t1 = new MyThread("Good morning", 1000);
        MyThread t2 = new MyThread("Hello", 2000);
        MyThread t3 = new MyThread("Welcome", 3000);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}