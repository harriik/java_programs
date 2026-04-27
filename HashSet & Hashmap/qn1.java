import java.util.HashSet;
import java.util.Scanner;
public class qn1{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        System.out.println("Enter the string: ");
        String str = s.nextLine();
        String[] words = str.split(" ");
        for(String word: words){
            set.add(word);
        }
        System.out.println("Unique words: " + set);
    }
}