package work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanCalculator extends JFrame implements ActionListener {

    JLabel amountLabel = new JLabel("Amount Requested:");
    JLabel durationLabel = new JLabel("Duration (years):");
    JLabel resultLabel = new JLabel("Total Return:");


    JTextField amountField = new JTextField();
    JTextField durationField = new JTextField();
    JTextField resultField = new JTextField();


    JButton calcButton = new JButton("Calculate");

    public LoanCalculator() {

        setTitle("Loan Interest Calculator");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));


        resultField.setEditable(false);


        add(amountLabel);
        add(amountField);

        add(durationLabel);
        add(durationField);

        add(resultLabel);
        add(resultField);

        add(new JLabel());
        add(calcButton);


        calcButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            int years = Integer.parseInt(durationField.getText());


            double rate = 0.10;
            double totalReturn = amount + 12000;

            resultField.setText(String.format("%.2f", totalReturn));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new LoanCalculator();
    }
}
