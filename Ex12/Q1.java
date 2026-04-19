import java.io.*;

public class Q1 {
    public static void main(String[] args) {

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("input.txt"))
        ) {
            System.out.println("Enter text (type STOP to end):");

            String line;
            while (!(line = br.readLine()).equals("STOP")) {
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing input file");
        }

        int lines = 0, words = 0, chars = 0;
        int upper = 0, lower = 0, vowels = 0, digits = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                lines++;
                chars += line.length();

                String[] w = line.split("\\s+");
                words += w.length;

                for (char c : line.toCharArray()) {
                    if (Character.isUpperCase(c)) upper++;
                    if (Character.isLowerCase(c)) lower++;
                    if ("AEIOUaeiou".indexOf(c) != -1) vowels++;
                    if (Character.isDigit(c)) digits++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        try (PrintWriter pw = new PrintWriter("report.txt")) {
            pw.println("----- FILE ANALYSIS REPORT -----");
            pw.println("Total Lines        : " + lines);
            pw.println("Total Words        : " + words);
            pw.println("Total Characters   : " + chars);
            pw.println("Uppercase Letters  : " + upper);
            pw.println("Lowercase Letters  : " + lower);
            pw.println("Vowels             : " + vowels);
            pw.println("Digits             : " + digits);
        } catch (IOException e) {
            System.out.println("Error writing report");
        }

        try (
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("uppercase.txt"))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toUpperCase());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error converting file");
        }

        System.out.println("Processing complete!");
    }
}