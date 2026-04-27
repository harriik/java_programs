import java.util.HashSet;
import java.util.Scanner;

public class Qn4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("java");
        set.add("JAVA");
        System.out.println("HashSet: " + set);
        System.out.println("Size of HashSet: " + set.size());
        
    }
    
}