package main;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class Main {
    public Font customFont;
    private JFrame fr;
    private JPanel p;
    private JTextField txt;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        // พยายามโหลดฟอนต์จากไฟล์ .ttf
        try {
            // กำหนดที่อยู่ของไฟล์ฟอนต์
            File fontFile = new File("font/customFont/Afacad-VariableFont_wght.ttf");  // ตั้ง path ให้ถูกต้อง
            // โหลดฟอนต์จากไฟล์ .ttf และกำหนดขนาดฟอนต์
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(30f);  // กำหนดขนาดฟอนต์เป็น 30

            // ลงทะเบียนฟอนต์ใน GraphicsEnvironment
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            System.err.println("Error loading font: " + e.getMessage());
            e.printStackTrace();  // แสดงรายละเอียดข้อผิดพลาด
        }

        // สร้างหน้าต่าง JFrame
        fr = new JFrame("Custom Font Example");
        p = new JPanel();
        
        // สร้าง JTextField และตั้งฟอนต์ที่โหลดมา
        txt = new JTextField("Hello, World!");
        if (customFont != null) {
            txt.setFont(customFont);  // ใช้ฟอนต์ที่โหลด
        } else {
            txt.setFont(new Font("Arial", Font.PLAIN, 10));  // ถ้าฟอนต์ไม่โหลดสำเร็จ ใช้ฟอนต์เริ่มต้น
        }

        // เพิ่ม JTextField ไปที่ JPanel
        p.add(txt);

        // เพิ่ม JPanel ไปที่ JFrame
        fr.add(p);

        // ตั้งค่าการแสดงผล JFrame
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(400, 200);  // ตั้งขนาดหน้าต่าง
        fr.setLocationRelativeTo(null);  // จัดให้อยู่กลางหน้าจอ
        fr.setVisible(true);  // ทำให้หน้าต่างแสดง
    }
}
