import java.io.*;

public class qn7 {
    static final int NAME_SIZE = 20;
    static final int RECORD_SIZE = 4 + (NAME_SIZE * 2) + 8;

    static void writeName(RandomAccessFile raf, String name) throws IOException {
        StringBuilder sb = new StringBuilder(name);
        sb.setLength(NAME_SIZE);
        raf.writeChars(sb.toString());
    }

    static String readName(RandomAccessFile raf) throws IOException {
        char[] name = new char[NAME_SIZE];
        for (int i = 0; i < NAME_SIZE; i++)
            name[i] = raf.readChar();
        return new String(name).trim();
    }

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("prod.dat", "rw");
        raf.seek(0);
        raf.writeInt(1);
        writeName(raf, "Pen");
        raf.writeDouble(10);

        raf.writeInt(2);
        writeName(raf, "Book");
        raf.writeDouble(50);

        raf.seek(0);
        while (raf.getFilePointer() < raf.length()) {
            int id = raf.readInt();
            String name = readName(raf);
            double price = raf.readDouble();

            System.out.println(id + " " + name + " " + price);
        }

        raf.seek(0 * RECORD_SIZE + 4 + NAME_SIZE * 2);
        raf.writeDouble(20);

        raf.close();
    }
}