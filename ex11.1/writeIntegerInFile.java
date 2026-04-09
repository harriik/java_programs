import java.io.FileOutputStream;
public class writeIntegerInFile {
    public static void main(String[] args) {
            try (FileOutputStream fos = new FileOutputStream("integer.txt")) {
                int number = 12345;
                fos.write(number);
                System.out.println("Integer " + number + " written to file.");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
    }
}

