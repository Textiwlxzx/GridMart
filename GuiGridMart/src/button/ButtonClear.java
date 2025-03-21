package button;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;

public class ButtonClear extends JButton{
    
    private int radius = 0;
    private Color borderColor;
    
    public ButtonClear(){
        setContentAreaFilled(false);
        setBackground(new Color(0, 0, 0, 0));
        setBorderPainted(false);
        setForeground(new Color(54, 54, 54));
        setFont(new Font("Afacad", Font.BOLD, 16));
        
    }
    
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }
    
    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint(); // รีเฟรชเมื่อมีการเปลี่ยนแปลงสีกรอบ
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
    
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(1));
        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() -1, getHeight() -1, radius, radius));
        
        g2.dispose();
        super.paintComponent(g);  
    }
}