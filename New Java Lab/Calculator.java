import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, modButton, factButton, clrButton, eqlButton;
    private Font font;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        font = new Font("Arial", Font.BOLD, 25);

        JPanel panelTextField = new JPanel(new GridLayout(1, 1));
        textField = new JTextField();
        textField.setFont(font);
        textField.setEditable(false);
        panelTextField.add(textField);

        JPanel panelButtons = new JPanel(new GridLayout(4, 4, 5, 5));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i));
            panelButtons.add(numberButtons[i]);
        }

        addButton = createButton("+");
        subButton = createButton("-");
        mulButton = createButton("*");
        divButton = createButton("/");
        modButton = createButton("%");
        factButton = createButton("!");
        clrButton = createButton("C");
        eqlButton = createButton("=");

        functionButtons = new JButton[]{addButton, subButton, mulButton, divButton, modButton, factButton, clrButton, eqlButton};
        for (JButton button : functionButtons) {
            panelButtons.add(button);
        }

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        modButton.addActionListener(this);
        factButton.addActionListener(this);
        clrButton.addActionListener(this);
        eqlButton.addActionListener(this);

        JPanel panelExtraButtons = new JPanel(new GridLayout(1, 3, 5, 5));
        panelExtraButtons.add(modButton);
        panelExtraButtons.add(factButton);
        panelExtraButtons.add(clrButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelTextField, BorderLayout.NORTH);
        getContentPane().add(panelButtons, BorderLayout.CENTER);
        getContentPane().add(panelExtraButtons, BorderLayout.SOUTH);
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setFont(font);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        if (buttonClicked == clrButton) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        } else if (buttonClicked == eqlButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    result = num1 % num2;
                    break;
                case '!':
                    result = factorial((int) num1);
                    break;
            }
            textField.setText(String.valueOf(result));
        } else if (buttonClicked == factButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '!';
            textField.setText("");
        } else {
            for (int i = 0; i < 10; i++) {
                if (buttonClicked == numberButtons[i]) {
                    textField.setText(textField.getText() + i);
                }
            }
            if (buttonClicked == addButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
            if (buttonClicked == subButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if (buttonClicked == mulButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if (buttonClicked == divButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
            if (buttonClicked == modButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '%';
                textField.setText("");
            }
        }
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculator().setVisible(true);
        });
    }
}
