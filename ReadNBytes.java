import java.io.FileInputStream;
import java.io.IOException;

public class ReadNBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("ReadNBytes.java");
        int n = 10;
        byte[] b = new byte[n];
        fis.read(b);

        System.out.println("First " + n + " bytes:");
        System.out.println(new String(b));

        fis.close();
    }
}