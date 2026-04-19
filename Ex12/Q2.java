import java.io.*;
import java.util.Scanner;

public class Q2 {

    static final int NAME_SIZE = 20;
    static final int DEPT_SIZE = 20;

    public static void writeString(RandomAccessFile raf, String str, int size) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        sb.setLength(size);
        raf.writeChars(sb.toString());
    }

    public static String readString(RandomAccessFile raf, int size) throws IOException {
        char[] data = new char[size];
        for (int i = 0; i < size; i++) {
            data[i] = raf.readChar();
        }
        return new String(data).trim();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("payroll.dat", "rw");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.Display 3.Search 4.Update Salary 5.Delete 6.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    raf.seek(raf.length());

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Dept: ");
                    String dept = sc.nextLine();

                    System.out.print("Salary: ");
                    double sal = sc.nextDouble();

                    raf.writeInt(id);
                    writeString(raf, name, NAME_SIZE);
                    writeString(raf, dept, DEPT_SIZE);
                    raf.writeDouble(sal);
                    raf.writeBoolean(true);
                    break;

                case 2:
                    raf.seek(0);
                    while (raf.getFilePointer() < raf.length()) {
                        int i = raf.readInt();
                        String n = readString(raf, NAME_SIZE);
                        String d = readString(raf, DEPT_SIZE);
                        double s = raf.readDouble();
                        boolean active = raf.readBoolean();

                        if (active)
                            System.out.println(i + " " + n + " " + d + " " + s);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();
                    raf.seek(0);

                    while (raf.getFilePointer() < raf.length()) {
                        int i = raf.readInt();
                        String n = readString(raf, NAME_SIZE);
                        String d = readString(raf, DEPT_SIZE);
                        double s = raf.readDouble();
                        boolean active = raf.readBoolean();

                        if (i == sid && active)
                            System.out.println(i + " " + n + " " + d + " " + s);
                    }
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    raf.seek(0);

                    while (raf.getFilePointer() < raf.length()) {
                        long pos = raf.getFilePointer();
                        int i = raf.readInt();

                        if (i == uid) {
                            raf.seek(pos + 4 + 40 + 40);
                            System.out.print("New Salary: ");
                            raf.writeDouble(sc.nextDouble());
                            break;
                        }
                        raf.skipBytes(40 + 40 + 8 + 1);
                    }
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();
                    raf.seek(0);

                    while (raf.getFilePointer() < raf.length()) {
                        long pos = raf.getFilePointer();
                        int i = raf.readInt();

                        if (i == did) {
                            raf.seek(pos + 4 + 40 + 40 + 8);
                            raf.writeBoolean(false);
                            break;
                        }
                        raf.skipBytes(40 + 40 + 8 + 1);
                    }
                    break;

                case 6:
                    raf.close();
                    sc.close();
                    return;
            }
        }
    }
}