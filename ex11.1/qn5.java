import java.io.*;

public class qn5 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("image.jpg");
        int count = 0, zero = 0, b;
        while ((b = fis.read()) != -1) {
            count++;
            if (b == 0) zero++;
        }

        System.out.println("Total Bytes: " + count);
        System.out.println("Zero Bytes: " + zero);

        fis.close();

        fis = new FileInputStream("image.jpg");
        for (int i = 0; i < 100; i++) {
            System.out.print(fis.read() + " ");
        }
        fis.close();

        FileOutputStream fos = new FileOutputStream("image.jpg", true);
        fos.write("END".getBytes());
        fos.close();
    }
}