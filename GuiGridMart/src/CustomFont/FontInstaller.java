package CustomFont;

import java.awt.*;
import javax.swing.*;
import java.io.InputStream;
import java.io.IOException;

public class FontInstaller {
    public static void main(String[] args) {

        try {
            InputStream fontStream = FontInstaller.class.getResourceAsStream("/font/customFont/Afacad-VariableFont_wght.ttf");

            if (fontStream == null) {
                System.out.println("Font not found");
                return;
            }

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(30f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Font Example");
            JPanel panel = new JPanel();

            Font systemFont = new Font("Afacad", Font.PLAIN, 24);

            JTextField textField = new JTextField("Hello, Custom Font!");
            textField.setFont(systemFont);
            panel.add(textField);

            frame.add(panel);
            frame.setSize(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}