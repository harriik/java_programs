import java.io.*;

public class qn2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("input.txt");
        FileOutputStream fos = new FileOutputStream("encrypted.dat");

        int key = 5;
        int b;

        while ((b = fis.read()) != -1) {
            fos.write(b ^ key);
        }
        fis.close();
        fos.close();

        FileInputStream fis2 = new FileInputStream("encrypted.dat");
        FileOutputStream fos2 = new FileOutputStream("decrypted.txt");

        while ((b = fis2.read()) != -1) {
            fos2.write(b ^ key);
        }

        fis2.close();
        fos2.close();

        System.out.println("Encryption & Decryption Done");
    }
}