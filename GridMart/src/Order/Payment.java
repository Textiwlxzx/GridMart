package Order;
import javax.swing.*;
import java.awt.*;

public class Payment extends JPanel {

    private JRadioButton b1, b2;
    private ButtonGroup g1;

    public Payment() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        g1 = new ButtonGroup();
        b1 = new JRadioButton("Cash");
        b2 = new JRadioButton("QR Code");
        setBackground(Color.WHITE);
        Font bigFont = new Font("Afacad", Font.PLAIN, 24);
        b1.setFont(bigFont);
        b2.setFont(bigFont);

        b1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        b2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        g1.add(b1);
        g1.add(b2);

        add(b1);
        add(b2);
    }
    public boolean isCashSelected() {
    return b1.isSelected();
}

    public boolean isQRSelected() {
     return b2.isSelected();
        }
}
