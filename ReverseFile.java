import java.io.FileInputStream;
import java.io.IOException;

public class ReverseFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("ReverseFile.java");
        byte[] data = fis.readAllBytes();
        System.out.println("File in reverse order:");
        for (int i = data.length - 1; i >= 0; i--) {
            System.out.print((char) data[i]);
        }
        fis.close();
    }
}