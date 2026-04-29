import java.util.HashMap;
import java.util.Scanner;

public class Qn6 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = s.nextLine();
        System.out.println("Entered String: " + str);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);  
        }
        for(char key: map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }
        
    }
}