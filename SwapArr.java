public class SwapArr {

    public static <T> void swapArray(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            T temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    public static <T extends Comparable<T>> void analyzer(T[] arr) {
        if (arr.length == 0) return;

        T min = arr[0];
        T max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(min) < 0)
                min = arr[i];

            if (arr[i].compareTo(max) > 0)
                max = arr[i];
        }

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);

        System.out.println("Frequency of elements:");
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                continue;

            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(arr[i] + " -> " + count);
        }
    }

    public static void main(String[] args) {

        Integer[] intArr = {10, 20, 30, 40, 10};
        Float[] floatArr = {1.1f, 2.2f, 3.3f, 1.1f};
        String[] strArr = {"Java", "C", "C++", "Go"};

        System.out.println("Integer Array");
        swapArray(intArr);
        analyzer(intArr);

        System.out.println("\nFloat Array");
        swapArray(floatArr);
        analyzer(floatArr);

        System.out.println("\nString Array");
        swapArray(strArr);
        analyzer(strArr);
    }
}
