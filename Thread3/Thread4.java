public class Thread4 {
    public static void main(String[] args) {
        Thread current = Thread.currentThread();

        System.out.println("Thread ID: " + current.getId());
        System.out.println("Thread Name: " + current.getName());
        System.out.println("Thread Priority: " + current.getPriority());
    }
}