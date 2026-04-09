import java.io.*;

class Student {
    int roll;
    String name;
    double marks;

    Student(int r, String n, double m) {
        roll = r;
        name = n;
        marks = m;
    }
}

public class StudentFile {
    static final String FILE = "students.dat";

    // Add Student
    public static void addStudent(Student s) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE, true));
        dos.writeInt(s.roll);
        dos.writeUTF(s.name);
        dos.writeDouble(s.marks);
        dos.close();
    }

    // Display All
    public static void display() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(FILE));
        try {
            while (true) {
                System.out.println(dis.readInt() + " " + dis.readUTF() + " " + dis.readDouble());
            }
        } catch (EOFException e) {
            dis.close();
        }
    }

    // Search
    public static void search(int key) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(FILE));
        try {
            while (true) {
                int r = dis.readInt();
                String n = dis.readUTF();
                double m = dis.readDouble();

                if (r == key) {
                    System.out.println("Found: " + n + " " + m);
                    return;
                }
            }
        } catch (EOFException e) {
            System.out.println("Not Found");
            dis.close();
        }
    }

    // Delete
    public static void delete(int key) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(FILE));
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("temp.dat"));

        try {
            while (true) {
                int r = dis.readInt();
                String n = dis.readUTF();
                double m = dis.readDouble();

                if (r != key) {
                    dos.writeInt(r);
                    dos.writeUTF(n);
                    dos.writeDouble(m);
                }
            }
        } catch (EOFException e) {
            dis.close();
            dos.close();
        }

        new File(FILE).delete();
        new File("temp.dat").renameTo(new File(FILE));
    }

    public static void main(String[] args) throws Exception {
        addStudent(new Student(1, "Hari", 90));
        addStudent(new Student(2, "Ram", 85));

        display();
        search(1);
        delete(2);

        System.out.println("After delete:");
        display();
    }
}