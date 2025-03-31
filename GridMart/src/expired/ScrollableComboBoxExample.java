/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expired;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ScrollableComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox with ScrollBar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // รายการของ JComboBox
        String[] months = {
            "Month", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        // สร้าง JComboBox
        JComboBox<String> jComboBox1 = new JComboBox<>(months);
        jComboBox1.setBackground(new Color(204, 204, 255));
        jComboBox1.setFont(new Font("Afacad", Font.PLAIN, 24));
        jComboBox1.setBorder(new RoundedBorder(20));
        jComboBox1.setPreferredSize(new Dimension(180, 40));

        // ทำให้ JComboBox มี Scrollbar
        jComboBox1.setMaximumRowCount(5); // กำหนดให้แสดงสูงสุด 5 รายการก่อนต้องเลื่อน

        // ตั้งค่า Layout และเพิ่ม JComboBox เข้าไปใน Frame
        frame.setLayout(new FlowLayout());
        frame.add(jComboBox1);
        frame.setVisible(true);
    }

    // Custom border สำหรับทำให้ JComboBox มีขอบมน
    static class RoundedBorder extends AbstractBorder {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius, this.radius, this.radius, this.radius);
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(c.getForeground());
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.draw(new RoundRectangle2D.Float(x, y, width - 1, height - 1, radius, radius));
        }
    }
}

