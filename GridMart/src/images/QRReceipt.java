
package images;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class QRReceipt extends JPanel {
    
    private Image logoImage;
    
    public QRReceipt (){
        logoImage = new ImageIcon(getClass().getResource("/images/QRReceipt.jpg")).getImage();
        
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (logoImage != null) {
            // ได้ขนาดของ panel
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            
            // ขนาดของรูปภาพ
            int imgWidth = logoImage.getWidth(this);
            int imgHeight = logoImage.getHeight(this);
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
            g.drawImage(logoImage, x, y, newWidth, newHeight, this);
        }
    }
}
