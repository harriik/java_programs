import java.io.*;

public class qn9 {
    public static void main(String[] args) throws Exception {
        DataInputStream dis = new DataInputStream(new FileInputStream("marks.dat"));
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("report.dat"));

        try {
            while (true) {
                int roll = dis.readInt();
                double m1 = dis.readDouble();
                double m2 = dis.readDouble();
                double m3 = dis.readDouble();

                double total = m1 + m2 + m3;
                double avg = total / 3;

                String grade = avg >= 75 ? "A" : avg >= 50 ? "B" : "C";

                dos.writeInt(roll);
                dos.writeDouble(total);
                dos.writeDouble(avg);
                dos.writeUTF(grade);
            }
        } catch (EOFException e) {
        }

        dis.close();
        dos.close();

        System.out.println("Report Generated");
    }
}