import java.util.HashMap;

public class Qn9 {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        String str1 = "ccaa";
        String str2 = "ccac";
        if (str1.length() != str2.length()) {
            System.out.println("Not anagrams");
            return;
        }
        for (char ch : str1.toCharArray()) {
            map.put(String.valueOf(ch), map.getOrDefault(String.valueOf(ch), 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            if (!map.containsKey(String.valueOf(ch))) {
                System.out.println("Not anagrams");
                return;
            }
            map.put(String.valueOf(ch), map.getOrDefault(String.valueOf(ch), 0) - 1);
        }
        for (int count : map.values()) {
            if (count != 0) {
                System.out.println("Not anagrams");
                return;
            }
        }
        System.out.println("Anagrams");
    }
}