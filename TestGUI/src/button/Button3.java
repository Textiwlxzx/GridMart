package button;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class Button3 extends JButton{
    
    private int radius = 0;
    
    public Button3(){
        setContentAreaFilled(false);
        setBackground(new Color(100, 200, 255));
        setFont(new Font("Arial", Font.BOLD, 16));
    }
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius));
                
        super.paintComponent(g);
        g2.dispose();
    }
}
