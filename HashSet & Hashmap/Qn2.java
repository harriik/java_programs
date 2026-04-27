import java.util.*;
public class Qn2{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        System.out.println("Enter the string 1: ");
        String str1 = s.nextLine();
        System.out.println("Enter the string 2: ");
        String str2 = s.nextLine();
        String[] words = str1.split(" ");
        for(String word: words){
            set.add(word);
        }
        for(String word: set){
            if(str2.contains(word)){
                System.out.println(word);
            }
        }
    }
}