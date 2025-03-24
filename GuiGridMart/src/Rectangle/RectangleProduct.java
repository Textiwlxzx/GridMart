package Rectangle;

import javax.swing.JPanel;
import java.awt.*;

public class RectangleProduct extends JPanel{
    
    public RectangleProduct(){

    }
    

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color (255, 255, 255,127));
        g2.fillRoundRect(0, 0, 287, 288, 35, 35);
        
        super.paintComponent(g);
    }
}
