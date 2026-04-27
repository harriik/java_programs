import java.io.FileInputStream;
import java.io.FileOutputStream;

// public class ByteStreamEx {
//     public static void main(String[] args) throws Exception {
//         FileInputStream fis = new FileInputStream("input.txt");
//         int ch, count = 0;
        
//         while ((ch = fis.read()) != -1) {
//             count++;
//             System.out.print((char) ch);
//         }
//         System.out.println("\nTotal bytes in file: " + count);

//         fis.close();
//     }
// }

/* 
import java.io.FileInputStream;

public class ByteStreamEx {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("input.txt");
        int count = 0;
        int ch;

        while((ch = fis.read()) != -1){
            char c = (char) ch;
            if("aeiouAEIOU".indexOf(c) != -1){
                count++;
            }
        }
        System.out.println("Total vowels in file: " + count);
        fis.close();
    }
}

*/


public class ByteStreamEx {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("input.txt");
        FileOutputStream fos = new FileOutputStream("input.txt");
        int ch;

        while((ch = fis.read()) != -1){
            char c = Character.toUpperCase((char) ch);
            fos.write(c);
        }
        fis.close();
        fos.close();
    }
}
