import java.io.*;
import java.util.*;

public class qn4 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1.Create 2.Write 3.Read 4.Update 5.Delete 6.Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                File f = new File("test.txt");
                f.createNewFile();
                System.out.println("Created");
            }

            else if (ch == 2) {
                FileWriter fw = new FileWriter("test.txt");
                fw.write("Hello World");
                fw.close();
            }

            else if (ch == 3) {
                File f = new File("test.txt");
                if (f.exists()) {
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    System.out.println(br.readLine());
                    br.close();

                    System.out.println("Size: " + f.length());
                    System.out.println("Last Modified: " + f.lastModified());
                }
            }

            else if (ch == 4) {
                FileWriter fw = new FileWriter("test.txt", true);
                fw.write("\nUpdated Line");
                fw.close();
            }

            else if (ch == 5) {
                new File("test.txt").delete();
            }

            else break;
        }
    }
}