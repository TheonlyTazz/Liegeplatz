import javax.swing.*;
import java.awt.*;

public class LiegeplatzdatenApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Liegeplatzdaten");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.setLayout(new BorderLayout());

            // Header Panel
            JPanel headerPanel = new JPanel(new BorderLayout());
            headerPanel.setBackground(Color.LIGHT_GRAY);
            JLabel titleLabel = new JLabel("Liegeplatzdaten", JLabel.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            headerPanel.add(titleLabel, BorderLayout.CENTER);

            // Logo
            ImageIcon logoIcon = new ImageIcon("logo.png"); // Update with correct path
            JLabel logoLabel = new JLabel(logoIcon);
            headerPanel.add(logoLabel, BorderLayout.WEST);

            // Main Content Panel
            JPanel contentPanel = new JPanel(new GridLayout(1, 2));

            // Form Panel
            JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));
            formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            formPanel.add(new JLabel("Bezeichnung:"));
            JTextField designationField = new JTextField("A34-1");
            designationField.setEditable(false);
            designationField.setForeground(Color.ORANGE);
            formPanel.add(designationField);

            formPanel.add(new JLabel("Länge (m):"));
            formPanel.add(new JTextField());

            formPanel.add(new JLabel("Breite (m):"));
            formPanel.add(new JTextField());

            formPanel.add(new JLabel("Wassertiefe (cm):"));
            formPanel.add(new JTextField());

            formPanel.add(new JLabel("Status:"));
            JComboBox<String> statusComboBox = new JComboBox<>(new String[]{"verfügbar"});
            formPanel.add(statusComboBox);

            // Image Panel
            JPanel imagePanel = new JPanel();
            imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
            imagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            JLabel imageLabel = new JLabel("Bild:");
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            imagePanel.add(imageLabel);

            ImageIcon imageIcon = new ImageIcon("grafik.jpg"); // Update with correct path
            JLabel imageDisplay = new JLabel(imageIcon);
            imageDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
            imagePanel.add(imageDisplay);

            contentPanel.add(formPanel);
            contentPanel.add(imagePanel);

            // Button Panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

            JButton saveButton = new JButton("Daten speichern");
            JButton newImageButton = new JButton("Neues Bild");
            JButton closeButton = new JButton("Dialog schließen");

            closeButton.addActionListener(e -> frame.dispose());

            buttonPanel.add(saveButton);
            buttonPanel.add(newImageButton);
            buttonPanel.add(closeButton);

            frame.add(headerPanel, BorderLayout.NORTH);
            frame.add(contentPanel, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
