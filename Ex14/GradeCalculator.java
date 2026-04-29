import java.awt.*;
import java.awt.event.*;

public class GradeCalculator extends Frame implements ActionListener {
    TextField t1, t2, t3;
    Label result;
    Button btn;

    public GradeCalculator() {
        setTitle("Grade Calculator");
        setLayout(new FlowLayout());

        add(new Label("Mark 1:"));
        t1 = new TextField(5);
        add(t1);

        add(new Label("Mark 2:"));
        t2 = new TextField(5);
        add(t2);

        add(new Label("Mark 3:"));
        t3 = new TextField(5);
        add(t3);

        btn = new Button("Calculate");
        add(btn);

        result = new Label("");
        add(result);

        btn.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setSize(300, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int m1 = Integer.parseInt(t1.getText());
            int m2 = Integer.parseInt(t2.getText());
            int m3 = Integer.parseInt(t3.getText());

            int total = m1 + m2 + m3;
            float avg = total / 3.0f;

            String grade;
            if (avg >= 75) grade = "A";
            else if (avg >= 60) grade = "B";
            else if (avg >= 50) grade = "C";
            else grade = "Fail";

            result.setText("Total: " + total + " Avg: " + avg + " Grade: " + grade);
        } catch (Exception ex) {
            result.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new GradeCalculator();
    }
}