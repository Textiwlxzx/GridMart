
package Background;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class backgroundlogin extends JPanel {
    
    private Image backgroundImage;
    
    public backgroundlogin(){
        setBackground(new Color(242, 242, 242));
        backgroundImage = new ImageIcon(getClass().getResource("/images/gradientbg.png")).getImage();
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
