import java.io.*;

public class qn3 {
    static final int NAME_SIZE = 20;

    public static void writeString(RandomAccessFile raf, String str) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        sb.setLength(NAME_SIZE);
        raf.writeChars(sb.toString());
    }

    public static String readString(RandomAccessFile raf) throws IOException {
        char[] name = new char[NAME_SIZE];
        for (int i = 0; i < NAME_SIZE; i++)
            name[i] = raf.readChar();
        return new String(name).trim();
    }

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("emp.dat", "rw");

        raf.writeInt(1);
        writeString(raf, "Hari");
        raf.writeDouble(20000);

        raf.writeInt(2);
        writeString(raf, "Raj");
        raf.writeDouble(25000);

        raf.seek(0);
        double total = 0;

        while (raf.getFilePointer() < raf.length()) {
            int id = raf.readInt();
            String name = readString(raf);
            double sal = raf.readDouble();

            System.out.println(id + " " + name + " " + sal);
            total += sal;
        }

        System.out.println("Total Payroll = " + total);

        raf.seek(0);
        while (raf.getFilePointer() < raf.length()) {
            long pos = raf.getFilePointer();

            int id = raf.readInt();
            raf.skipBytes(NAME_SIZE * 2);
            double sal = raf.readDouble();

            if (id == 1) {
                raf.seek(pos + 4 + NAME_SIZE * 2);
                raf.writeDouble(30000);
            }
        }

        raf.close();
    }
}