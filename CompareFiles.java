import java.io.FileInputStream;
import java.io.IOException;

public class CompareFiles {
    public static void main(String[] args) throws IOException {
        FileInputStream f1 = new FileInputStream("file1.txt");
        FileInputStream f2 = new FileInputStream("file2.txt");
        int b1, b2;
        boolean identical = true;
        while ((b1 = f1.read()) != -1 && (b2 = f2.read()) != -1) {
            if (b1 != b2) {
                identical = false;
                break;
            }
        }
        if (f1.read() != -1 || f2.read() != -1) {
            identical = false;
        }
        if (identical)
            System.out.println("Files are identical");
        else
            System.out.println("Files are different");

        f1.close();
        f2.close();
    }
}