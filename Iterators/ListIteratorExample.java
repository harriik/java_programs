import java.util.*;

public class ListIteratorExample {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        ListIterator<String> it = list.listIterator();

        System.out.println("Forward Traversal:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("Backward Traversal:");
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }
}