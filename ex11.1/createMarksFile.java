import java.io.*;

public class createMarksFile {
    public static void main(String[] args) throws Exception {

        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("marks.dat"));

        // Student 1
        dos.writeInt(1);
        dos.writeDouble(80);
        dos.writeDouble(75);
        dos.writeDouble(90);

        // Student 2
        dos.writeInt(2);
        dos.writeDouble(60);
        dos.writeDouble(65);
        dos.writeDouble(70);

        // Student 3
        dos.writeInt(3);
        dos.writeDouble(45);
        dos.writeDouble(50);
        dos.writeDouble(55);

        dos.close();

        System.out.println("marks.dat created successfully");
    }
}