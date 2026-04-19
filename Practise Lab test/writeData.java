import java.io.*;

class WriteData {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("product.dat"))) {

            dos.writeInt(1);
            dos.writeUTF("Pen");
            dos.writeInt(10);
            dos.writeDouble(5.5);

            dos.writeInt(2);
            dos.writeUTF("Book");
            dos.writeInt(20);
            dos.writeDouble(50.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}