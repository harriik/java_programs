import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;
public class Qn7{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String line = s.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = line.split(" ");
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(String key : map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }
        System.out.println("Highest value: "+ Collections.max(map.values()));
    }
}