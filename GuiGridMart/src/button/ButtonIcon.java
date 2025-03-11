package button;

import java.awt.Font;
import javax.swing.*;

public class ButtonIcon extends JButton{
    
    public ButtonIcon(){
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setFont(new Font("Afacad", Font.BOLD, 16));
    }
}
