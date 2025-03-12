package button;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;

public class ButtonClear extends JButton{
    
    private int radius = 0;
    
    public ButtonClear(){
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(new Color(54, 54, 54));
        setFont(new Font("Afacad", Font.BOLD, 16));
    }
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
        g2.setColor(getForeground());
        g2.setStroke(new BasicStroke(1));
        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() -1, getHeight() -1, radius, radius));
        
        g2.dispose();
        super.paintComponent(g);        
    }
}