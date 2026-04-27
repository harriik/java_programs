import java.util.*;

public class IteratorVsForEach {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        try {
            for (Integer x : list) {
                list.remove(x); 
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException caught when removing in for-each loop!");
        }

        list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer val = it.next();
            if (val % 2 == 0) { 
                it.remove();
            }
        }

        System.out.println("Remaining elements after safe removal with Iterator: " + list);
    }
}
