import java.io.FileInputStream;
import java.io.IOException;

public class CountBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("CountBytes.java");
        int count = 0;    
        while(fis.read()!=-1) count++;
        System.out.println("Total bytes in file: " +count);
        fis.close();
    }
}