
package Menu;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class RoundedBorder extends AbstractBorder {
    private final int radius;

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        // วาดกรอบโค้ง
        g.setColor(new Color(54, 54, 54));  // สามารถเปลี่ยนสีกรอบได้ที่นี่
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius); // วาดกรอบโค้ง
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(5, 5, 5, 5); // เว้นระยะจากขอบ
    }
}

