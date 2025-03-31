package Table;

import javax.swing.*;

public class LayeredPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Popup Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // แสดง Popup แจ้งเตือน
        JOptionPane.showMessageDialog(frame, "Hello! This is a Popup.", "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
