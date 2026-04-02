import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterestCalculator extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, result;
    JTextField t1, t2, t3;
    JButton simpleBtn, compoundBtn, clearBtn;

    public InterestCalculator() {
        setTitle("Interest Calculator");
        setSize(400, 300);
        setLayout(new FlowLayout());

        l1 = new JLabel("Principal Amount:");
        l2 = new JLabel("Rate of Interest (%):");
        l3 = new JLabel("Time (Years):");
        l4 = new JLabel("Result:");

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);

        result = new JLabel("");

        simpleBtn = new JButton("Simple Interest");
        compoundBtn = new JButton("Compound Interest");
        clearBtn = new JButton("Clear");

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(simpleBtn);
        add(compoundBtn);
        add(clearBtn);
        add(l4); add(result);

        simpleBtn.addActionListener(this);
        compoundBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == clearBtn) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                result.setText("");
                return;
            }

            double p = Double.parseDouble(t1.getText());
            double r = Double.parseDouble(t2.getText());
            double t = Double.parseDouble(t3.getText());

            if (e.getSource() == simpleBtn) {
                double si = (p * r * t) / 100;
                result.setText("Simple Interest = " + si);
            } 
            else if (e.getSource() == compoundBtn) {
                double ci = p * Math.pow((1 + r / 100), t) - p;
                result.setText("Compound Interest = " + ci);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new InterestCalculator();
    }
}