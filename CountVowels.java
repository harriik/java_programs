import java.io.FileInputStream;
import java.io.IOException;

public class CountVowels {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("CountVowels.class");
        int ch, vowels = 0;
        while ((ch = fis.read()) != -1) {
            char c = (char) ch;
            if ("AEIOUaeiou".indexOf(c) != -1)  vowels++;
        }
        System.out.println("Number of vowels: " + vowels);
        fis.close();
    }
}