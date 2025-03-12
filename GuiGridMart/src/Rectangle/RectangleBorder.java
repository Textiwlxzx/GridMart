package Rectangle;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RectangleBorder extends JPanel {

    private int radius = 0;

    public RectangleBorder() {
        setOpaque(false);
        setBackground(new Color(255, 255, 255, 127));
        setForeground(new Color(0,0,0));

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
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 80, 80);

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getForeground());
        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 30, 30));
        
        super.paintComponent(g);
        g2.dispose();
    }
}
