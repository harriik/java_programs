import java.util.Scanner;
import java.util.HashSet;
public class Qn3{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        System.out.println("Enter the string: ");
        String str = s.nextLine();
        String[] words = str.split(" ");
        for(String word: words){
            set.add(word);        
        }
        for(String x: set){
            if(x.charAt(0) == 'a' || x.charAt(0) == 'e' || x.charAt(0) == 'i' || x.charAt(0) == 'o' || x.charAt(0) == 'u' ||
            x.charAt(0) == 'A' || x.charAt(0) == 'E' || x.charAt(0) == 'I' || x.charAt(0) == 'O' || x.charAt(0) == 'U'){
                System.out.println(x);
            }
        }

    }
}