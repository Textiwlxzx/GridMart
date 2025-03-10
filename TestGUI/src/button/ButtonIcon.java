
package button;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class ButtonIcon extends JButton{
    
    private ImageIcon iconButton;
    
    public ButtonIcon(){
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        
        iconButton = new ImageIcon(getClass().getResource("/images/setting.png"));
        setIcon(iconButton);
    }
}
