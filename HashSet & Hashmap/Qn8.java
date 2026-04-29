import java.util.HashMap;
import java.util.Scanner;

public class Qn8 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        while(true){
            System.out.println("1. Add entry\n2. Search by name\n3. Display all\n4. Exit");
            Scanner s = new Scanner(System.in);
            int choice = s.nextInt();
            s.nextLine(); 
            switch(choice){
                case 1:
                    System.out.println("Enter the Name: ");
                    String key = s.nextLine();
                    System.out.println("Enter the email: ");
                    String value = s.nextLine();
                    map.put(key, value);
                    break;
                case 2:
                    System.out.println("Enter the name to search: ");
                    String searchKey = s.nextLine();
                    if(map.containsKey(searchKey)){
                        System.out.println("Value for " + searchKey + ": " + map.get(searchKey));
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 3:
                    for(String k : map.keySet()){
                        System.out.println(k + ": " + map.get(key));
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}