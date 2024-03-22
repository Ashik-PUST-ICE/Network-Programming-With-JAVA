import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;

    private String input;
    private double num1, num2;
    private char operator;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        addButton = createButton("+");
        subtractButton = createButton("-");
        multiplyButton = createButton("*");
        divideButton = createButton("/");
        equalsButton = createButton("=");
        clearButton = createButton("C");

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i]);
        }

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton) e.getSource()).getText();
        if (buttonText.matches("\\d") || buttonText.equals(".")) {
            input = displayField.getText() + buttonText;
            displayField.setText(input);
        } else if ("+-*/".contains(buttonText)) {
            num1 = Double.parseDouble(displayField.getText());
            operator = buttonText.charAt(0);
            displayField.setText("");
        } else if (buttonText.equals("=")) {
            num2 = Double.parseDouble(displayField.getText());
            double result = performOperation(num1, num2, operator);
            displayField.setText(String.valueOf(result));
        } else if (buttonText.equals("C")) {
            displayField.setText("");
        }
    }

    private double performOperation(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleCalculator::new);
    }
}



// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

// public class SimpleCalculator extends JFrame implements ActionListener {
//     private JTextField displayField;
//     private JButton[] numberButtons;
//     private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;

//     private String input;
//     private double num1, num2;
//     private char operator;

//     public SimpleCalculator() {
//         setTitle("Simple Calculator");
//         setSize(300, 400);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         displayField = new JTextField();
//         displayField.setEditable(false);
//         add(displayField, BorderLayout.NORTH);

//         JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
//         addButton = createButton("+");
//         subtractButton = createButton("-");
//         multiplyButton = createButton("*");
//         divideButton = createButton("/");
//         equalsButton = createButton("=");
//         clearButton = createButton("C");

//         numberButtons = new JButton[10];
//         for (int i = 0; i < 10; i++) {
//             numberButtons[i] = createButton(String.valueOf(i));
//             buttonPanel.add(numberButtons[i]);
//         }

//         // Add decimal point button
//         JButton decimalButton = createButton(".");
//         buttonPanel.add(decimalButton);

//         buttonPanel.add(addButton);
//         buttonPanel.add(subtractButton);
//         buttonPanel.add(multiplyButton);
//         buttonPanel.add(divideButton);
//         buttonPanel.add(equalsButton);
//         buttonPanel.add(clearButton);

//         add(buttonPanel, BorderLayout.CENTER);
//         setVisible(true);
//     }

//     private JButton createButton(String label) {
//         JButton button = new JButton(label);
//         button.addActionListener(this);
//         return button;
//     }

//     public void actionPerformed(ActionEvent e) {
//         String buttonText = ((JButton) e.getSource()).getText();
//         if (buttonText.matches("\\d") || buttonText.equals(".")) {
//             input = displayField.getText() + buttonText;
//             displayField.setText(input);
//         } else if ("+-*/".contains(buttonText)) {
//             num1 = Double.parseDouble(displayField.getText());
//             operator = buttonText.charAt(0);
//             displayField.setText("");
//         } else if (buttonText.equals("=")) {
//             num2 = Double.parseDouble(displayField.getText());
//             double result = performOperation(num1, num2, operator);
//             displayField.setText(String.valueOf(result));
//         } else if (buttonText.equals("C")) {
//             displayField.setText("");
//         }
//     }

//     private double performOperation(double num1, double num2, char operator) {
//         switch (operator) {
//             case '+':
//                 return num1 + num2;
//             case '-':
//                 return num1 - num2;
//             case '*':
//                 return num1 * num2;
//             case '/':
//                 if (num2 == 0) {
//                     JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
//                     return 0;
//                 }
//                 return num1 / num2;
//             default:
//                 return 0;
//         }
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(SimpleCalculator::new);
//     }
// }
