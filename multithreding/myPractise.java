//Great learning about synchronization and how it can be used to avoid race conditions

class MyThread extends Thread {
    String name;
    static int count = 0;

    MyThread(String name){
        this.name = name;
    }   
    public void run(){
        for(int i=0; i<100000; i++){
            increment();
        }
    }

    static synchronized void increment(){
        count = count + 1;
    }
}

public class myPractise {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Thread 1");
        MyThread t2 = new MyThread("Thread 2");
        MyThread t3 = new MyThread("Thread 3");

        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Expected count: " + (3 * 100000));
        System.out.println("Actual count: " + MyThread.count);
    }
    
}