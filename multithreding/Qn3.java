//Write a program to create a class MyThread in this class a constructor,
// call the base class constructor, using super and starts the thread. The run
// method of the class starts after this. It can be observed that both main
// thread and created child thread are executed concurrently

class MyThread extends Thread{
    public MyThread(){
        super("Worker Thread");
        start();
    }
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(getName());
        }
    }
}
public class Qn3{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Execution");
        }
    }
}