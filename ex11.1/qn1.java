import java.io.*;
import java.util.Scanner;

public class qn1 {

    static final String FILE = "students.dat";

    static void addStudent(int roll, String name, double marks) throws IOException {
        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(FILE, true)); 

        dos.writeInt(roll);
        dos.writeUTF(name);
        dos.writeDouble(marks);

        dos.close();
        System.out.println("Student added.");
    }

    static void displayStudents() throws IOException {
        DataInputStream dis = new DataInputStream(
                new FileInputStream(FILE));

        try {
            while (true) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double marks = dis.readDouble();

                System.out.println(roll + " | " + name + " | " + marks);
            }
        } catch (EOFException e) {
            dis.close();
        }
    }

    static void searchStudent(int target) throws IOException {
        DataInputStream dis = new DataInputStream(
                new FileInputStream(FILE));

        boolean found = false;

        try {
            while (true) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double marks = dis.readDouble();

                if (roll == target) {
                    System.out.println("Found: " + name + " | " + marks);
                    found = true;
                }
            }
        } catch (EOFException e) {
            dis.close();
        }

        if (!found) System.out.println("Student not found.");
    }

    static void updateMarks(int targetRoll, double newMarks) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(FILE, "rw");

        try {
            while (true) {
                long pos = raf.getFilePointer();

                int roll = raf.readInt();
                String name = raf.readUTF();
                long markPos = raf.getFilePointer(); 
                double marks = raf.readDouble();

                if (roll == targetRoll) {
                    raf.seek(markPos);
                    raf.writeDouble(newMarks);
                    System.out.println("Marks updated.");
                    break;
                }
            }
        } catch (EOFException e) {
            System.out.println("Student not found.");
        }

        raf.close();
    }

    static void deleteStudent(int targetRoll) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(FILE));
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("temp.dat"));

        try {
            while (true) {
                int roll 
                = dis.readInt();
                String name = dis.readUTF();
                double marks = dis.readDouble();

                if (roll != targetRoll) {
                    dos.writeInt(roll);
                    dos.writeUTF(name);
                    dos.writeDouble(marks);
                }
            }
        } catch (EOFException e) {
            dis.close();
            dos.close();
        }

        new File(FILE).delete();
        new File("temp.dat").renameTo(new File(FILE));

        System.out.println("Record deleted if existed.");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student File Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All");
            System.out.println("3. Search");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Roll: ");
                    int r = sc.nextInt();
                    sc.nextLine(); 

                    System.out.print("Name: ");
                    String n = sc.nextLine();

                    System.out.print("Marks: ");
                    double m = sc.nextDouble();

                    addStudent(r, n, m);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    System.out.print("Enter roll to search: ");
                    searchStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter roll: ");
                    int ur = sc.nextInt();

                    System.out.print("New marks: ");
                    double nm = sc.nextDouble();

                    updateMarks(ur, nm);
                    break;

                case 5:
                    System.out.print("Enter roll to delete: ");
                    deleteStudent(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}