import java.io.FileInputStream;
import java.io.IOException;

public class CountLines {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("CountLines.java");
        int ch, lines = 0;
        while ((ch = fis.read()) != -1) {
            if (ch == '\n') {
                lines++;
            }
        }
        System.out.println("Number of lines: " + (lines + 1));
        fis.close();
    }
}