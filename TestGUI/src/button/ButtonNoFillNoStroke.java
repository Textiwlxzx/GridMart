package button;

import javax.swing.*;
import java.awt.*;

public class ButtonNoFillNoStroke extends JButton{
    
    private int radius = 0;
    
    public ButtonNoFillNoStroke(){
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setBackground(new Color(100, 200, 255));
        setForeground(new Color(0,0,0));
        setFont(new Font("Arial", Font.BOLD, 16));
    }
}