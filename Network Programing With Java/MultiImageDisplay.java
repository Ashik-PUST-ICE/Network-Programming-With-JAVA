import javax.swing.*;
import java.awt.*;

public class MultiImageDisplay extends JFrame {
    private JLabel[] imageLabels;

    public MultiImageDisplay() {
        setTitle("Multi Image Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Create an array to hold image icons and image labels
        ImageIcon[] imageIcons = new ImageIcon[3];
        imageLabels = new JLabel[3];

        // Load the images
        imageIcons[0] = new ImageIcon("image1.jpg");
        imageIcons[1] = new ImageIcon("image2.jpg");
        imageIcons[2] = new ImageIcon("image3.jpg");

        // Create JLabels for each image and set their properties
        for (int i = 0; i < 3; i++) {
            imageLabels[i] = new JLabel();
            imageLabels[i].setIcon(imageIcons[i]);
            imageLabels[i].setHorizontalAlignment(JLabel.CENTER);
        }

        // Add the JLabels to the JFrame
        getContentPane().setLayout(new GridLayout(1, 3));
        for (int i = 0; i < 3; i++) {
            getContentPane().add(imageLabels[i]);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MultiImageDisplay());
    }
}
