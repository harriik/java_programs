import java.io.*;

public class qn8 {
    public static void main(String[] args) throws Exception {

        FileInputStream f1 = new FileInputStream("file1.txt");
        FileInputStream f2 = new FileInputStream("file2.txt");

        int b1, b2;
        int pos = 0;
        int mismatch = 0;
        int firstMismatch = -1;

        while (true) {
            b1 = f1.read();
            b2 = f2.read();

            if (b1 == -1 && b2 == -1)
                break;

            if (b1 != b2) {
                mismatch++;

                if (firstMismatch == -1) {
                    firstMismatch = pos;
                }
            }

            pos++;
        }

        if (mismatch == 0) {
            System.out.println("Files are identical");
        } else {
            System.out.println("First mismatch at position: " + firstMismatch);
            System.out.println("Total mismatches: " + mismatch);
        }

        f1.close();
        f2.close();
    }
}