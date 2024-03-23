import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q3 extends JFrame implements ActionListener {
    JTextField nameField, rollField, regField, emailField;
    JPasswordField passwordField;
    JButton submitButton;

    public Q3() {
        setTitle("Student Form");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Name Panel
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        // Roll Number Panel
        JPanel rollPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel rollLabel = new JLabel("Roll Number:");
        rollField = new JTextField(10);
        rollPanel.add(rollLabel);
        rollPanel.add(rollField);

        // Registration Number Panel
        JPanel regPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel regLabel = new JLabel("Registration Number:");
        regField = new JTextField(10);
        regPanel.add(regLabel);
        regPanel.add(regField);

        // Email Panel
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);

        // Password Panel
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        // Submit Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        buttonPanel.add(submitButton);

        // Add components to the main panel
        mainPanel.add(namePanel);
        mainPanel.add(rollPanel);
        mainPanel.add(regPanel);
        mainPanel.add(emailPanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(buttonPanel);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String roll = rollField.getText();
        String reg = regField.getText();
        String email = emailField.getText();
        char[] password = passwordField.getPassword();


            // Data is valid, proceed with submission
            // You can handle the submission here, for now, just display a success message
            JOptionPane.showMessageDialog(this, "Student data submitted successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            // Clear fields after submission
            nameField.setText("");
            rollField.setText("");
            regField.setText("");
            emailField.setText("");
            passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Q3();
        });
    }
}
