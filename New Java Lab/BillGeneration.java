import javax.swing.*;
import java.awt.event.*;

public class BillGeneration extends JFrame implements ActionListener {
    private JLabel l;
    private JCheckBox cb1, cb2, cb3, cb4, cb5;
    private JButton b;

    BillGeneration() {
        setTitle("Food Ordering System");
        setSize(400, 400);
        setLayout(null);

        l = new JLabel("Select items to order:");
        l.setBounds(50, 50, 300, 20);

        cb1 = new JCheckBox("Pizza @ $100");
        cb1.setBounds(100, 80, 150, 20);

        cb2 = new JCheckBox("Burger @ $30");
        cb2.setBounds(100, 110, 150, 20);

        cb3 = new JCheckBox("Tea @ $10");
        cb3.setBounds(100, 140, 150, 20);

        cb4 = new JCheckBox("Salad @ $50"); // Added Salad item
        cb4.setBounds(100, 170, 150, 20);

        cb5 = new JCheckBox("Coffee @ $20"); // Added Coffee item
        cb5.setBounds(100, 200, 150, 20);

        b = new JButton("Order");
        b.setBounds(100, 250, 80, 30);
        b.addActionListener(this);

        add(l);
        add(cb1);
        add(cb2);
        add(cb3);
        add(cb4);
        add(cb5);
        add(b);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        float amount = 0;
        float vatRate = 0.15f; // 15% VAT rate
        float taxRate = 0.02f; // 2% tax rate
        StringBuilder msg = new StringBuilder("Items Ordered:\n");

        if (cb1.isSelected()) {
            amount += 100;
            msg.append("Pizza: $100\n");
        }
        if (cb2.isSelected()) {
            amount += 30;
            msg.append("Burger: $30\n");
        }
        if (cb3.isSelected()) {
            amount += 10;
            msg.append("Tea: $10\n");
        }
        if (cb4.isSelected()) {
            amount += 50;
            msg.append("Salad: $50\n");
        }
        if (cb5.isSelected()) {
            amount += 20;
            msg.append("Coffee: $20\n");
        }

        // Calculate VAT and tax
        float vatAmount = amount * vatRate;
        float taxAmount = amount * taxRate;

        // Add VAT and tax to the total amount
        amount += vatAmount + taxAmount;

        msg.append("-----------------\n");
        
        msg.append("VAT (15%): $" + vatAmount + "\n");
        msg.append("Tax (2%): $" + taxAmount + "\n");
        msg.append("-----------------\n");
        msg.append("Total: $" + amount);

        JOptionPane.showMessageDialog(this, msg.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new BillGeneration();
    }
}
