class TimedMessageThread extends Thread {
    String text;
    int delay;

    TimedMessageThread(String text, int delay) {
        this.text = text;
        this.delay = delay;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(text);
                Thread.sleep(delay);
                

            }
        } catch (InterruptedException e) {
        }
    }
}

public class Qn2 {
    public static void main(String[] args) throws Exception {
        TimedMessageThread morning = new TimedMessageThread("GoodMorning", 1000);
        TimedMessageThread hello = new TimedMessageThread("Hello",2000);
        TimedMessageThread welcome = new TimedMessageThread("Welcome",3000);

        morning.start();
        hello.start();
        welcome.start();

        morning.join();
        hello.join();
        welcome.join();

        System.out.println("Bye Bye See You All");
    }
}