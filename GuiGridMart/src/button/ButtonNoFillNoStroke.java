package button;

import javax.swing.*;
import java.awt.*;

public class ButtonNoFillNoStroke extends JButton{
    
    public ButtonNoFillNoStroke(){
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setBackground(new Color(100, 200, 255));
        setForeground(new Color(54, 54, 54));
        setFont(new Font("Afacad", Font.PLAIN, 16));
    }
}