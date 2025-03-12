package Rectangle;

import javax.swing.JPanel;
import java.awt.*;

public class Rectangle extends JPanel{
    
    private int radius = 0;
    
    public Rectangle(){
        setOpaque(false);
    }
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color (255, 255, 255,127));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        
        super.paintComponent(g);
    }
}
