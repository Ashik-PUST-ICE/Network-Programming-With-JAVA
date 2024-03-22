import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentForm extends JFrame implements ActionListener {
    private JLabel nameLabel, ageLabel, genderLabel, departmentLabel;
    private JTextField nameField, ageField, departmentField;
    private JComboBox<String> genderComboBox;
    private JButton submitButton;

    public StudentForm() {
        setTitle("Student Form");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);

        ageLabel = new JLabel("Age:");
        add(ageLabel);
        ageField = new JTextField();
        add(ageField);

        genderLabel = new JLabel("Gender:");
        add(genderLabel);
        String[] genders = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        add(genderComboBox);

        departmentLabel = new JLabel("Department:");
        add(departmentLabel);
        departmentField = new JTextField();
        add(departmentField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String ageStr = ageField.getText();
        String gender = (String) genderComboBox.getSelectedItem();
        String department = departmentField.getText();

        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String message = "Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nDepartment: " + department;
        JOptionPane.showMessageDialog(this, message, "Student Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentForm::new);
    }
}
