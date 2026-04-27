//Write a JAVA program that creates threads by extending Thread class.
//  First thread display “Good Morning “ every 1 sec, the second thread displays
//  “Hello “every 2 seconds and the third display “Welcome” every 3 seconds. 

class MyThread extends Thread{
    String name;
    int delay;
    public MyThread(String name, int delay){
        this.name = name;
        this.delay = delay;
    }
   
    public void run() {
        try{
                for(int i=0;i<3;i++){
                System.out.println(this.name);
                Thread.sleep(delay);
            }    
        }catch(InterruptedException e){
            System.out.println("Thread Interrupted");
        }
       
    }
}

public class Qn2
{
public static void main(String[] args) throws Exception{
MyThread t1 = new MyThread("Good Morning", 1000);
MyThread t2 = new MyThread("Hello", 2000);
MyThread t3 = new MyThread("Welcome", 3000);

t1.start();
t1.join();

t2.start();
t2.join();

t3.start();
t3.join();

System.out.println("Threads executed");
}
}
