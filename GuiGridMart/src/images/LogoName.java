
package images;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class LogoName extends JPanel {
    
    private Image logoName;
    
    public LogoName (){
        logoName = new ImageIcon(getClass().getResource("/images/logoName.png")).getImage();
        
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (logoName != null) {
            // ได้ขนาดของ panel
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            
            // ขนาดของรูปภาพ
            int imgWidth = logoName.getWidth(this);
            int imgHeight = logoName.getHeight(this);
            double aspectRatio = (double) imgWidth / imgHeight;
            
            // คำนวณขนาดใหม่เพื่อรักษาสัดส่วนของรูปภาพ
            int newWidth = panelWidth;
            int newHeight = (int) (panelWidth / aspectRatio);
            
            if (newHeight > panelHeight) {
                newHeight = panelHeight;
                newWidth = (int) (panelHeight * aspectRatio);
            }
            
            // คำนวณตำแหน่งให้อยู่กลาง
            int x = (panelWidth - newWidth) / 2;
            int y = (panelHeight - newHeight) / 2;
            
            // วาดรูปภาพ
            g.drawImage(logoName, x, y, newWidth, newHeight, this);
        }
    }
}
