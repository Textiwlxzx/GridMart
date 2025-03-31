package images;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.UIManager;

public class BGLogin extends JDesktopPane {

    private Image backgroundImage;

    public BGLogin() {
        backgroundImage = new ImageIcon("C:\\Users\\Chawa\\OneDrive\\NetbeansProjects\\Product-2\\src\\images\\bglogin.png").getImage();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //setBackground(UIManager.getColor("Desktop.background"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
