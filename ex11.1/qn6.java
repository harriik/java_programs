import java.io.*;
import java.time.*;

public class qn6 {
    public static void main(String[] args) throws Exception {
        File log = new File("log.txt");

        FileWriter fw = new FileWriter(log, true);
        fw.write(LocalDateTime.now() + " : Log Entry\n");
        fw.close();

        BufferedReader br = new BufferedReader(new FileReader(log));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();

        FileInputStream fis = new FileInputStream(log);
        FileOutputStream fos = new FileOutputStream("backup.txt");

        int b;
        while ((b = fis.read()) != -1)
            fos.write(b);

        fis.close();
        fos.close();
    }
}