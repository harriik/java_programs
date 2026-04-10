import java.io.*;

class Student {
    int roll;
    String name;
    double marks;

    Student(int r, String n, double m) {
        this.roll = r;
        this.name = n;
        this.marks = m;
    }
}

public class qn1 {

    public static void writeStudents() throws IOException {
        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("students.dat"));

        dos.writeInt(1);
        dos.writeUTF("Hari");
        dos.writeDouble(85.5);

        dos.writeInt(2);
        dos.writeUTF("Kesan");
        dos.writeDouble(90.0);

        dos.close();
    }

    public static void readStudents() throws IOException {
        DataInputStream dis = new DataInputStream(
                new FileInputStream("students.dat"));

        try {
            while (true) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double marks = dis.readDouble();

                System.out.println(roll + " " + name + " " + marks);
            }
        } catch (EOFException e) {
            dis.close();
        }
    }

    public static void searchStudent(int target) throws IOException {
        DataInputStream dis = new DataInputStream(
                new FileInputStream("students.dat"));

        boolean found = false;

        try {
            while (true) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double marks = dis.readDouble();

                if (roll == target) {
                    System.out.println("Found: " + name + " " + marks);
                    found = true;
                }
            }
        } catch (EOFException e) {
            if (!found) System.out.println("Not Found");
            dis.close();
        }
    }

    public static void main(String[] args) throws Exception {
        writeStudents();
        readStudents();
        searchStudent(1);
    }
}