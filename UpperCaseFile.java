import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UpperCaseFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("UpperCaseFile.java");
        FileOutputStream fos = new FileOutputStream("upper.txt");

        int ch;
        while ((ch = fis.read()) != -1) {
            char c = Character.toUpperCase((char) ch);
            fos.write(c);
        }

        fis.close();
        fos.close();
        System.out.println("File converted to uppercase.");
    }
}