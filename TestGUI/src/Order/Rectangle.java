/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author ADMIN
 */
public class Rectangle extends JPanel{

    public Rectangle(){
        setOpaque(false);
        setForeground(Color.WHITE);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color (255, 255, 255));
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
