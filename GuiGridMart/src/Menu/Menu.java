
package Menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Menu extends JComponent {
    
    private MigLayout layout;
    private JPanel panel;
    private String [][] menuItems = new String[][] {
        {"Product", "Drink", "Snack", "Delicatessen", "Essential", "Others"},
        {"Order"},
        {"Expired"},
        {"Purchased"}
        
    };
    
    public Menu() {
        init();
    }
    
    private void init() {
        layout = new MigLayout("wrap 1, fillx, gapy 28, inset 2", "fill");
        setLayout(layout);
        setOpaque(true);
        
        //menuItem
        for (int i = 0; i < menuItems.length; i++) {
            addMenu(menuItems[i][0], i);
        }
    }
    
    private void addMenu(String menuName, int index) {
        int length = menuItems[index].length;
        MenuItem item = new MenuItem(menuName, index, length > 1);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (length > 1) {
                    if (!item.isSelected()) {
                        item.setSelected(true);
                        toggleSubMenu(item, index, length);
                    } else {
                        //  Hide menu
                        hideMenu();
                        item.setSelected(false);
                    }
                }
            }

        });
        add(item);
        revalidate();
        repaint();
    }
    
    private void addSubMenu(MenuItem item, int index, int length, int indexZOrder) {
        panel = new JPanel(new MigLayout("wrap 1, fillx, gapy 10, inset 2", "fill"));

        panel.setOpaque(false);
        for (int i = 1; i < length; i++) {
            MenuItem subItem = new MenuItem(menuItems[index][i], i, false);
            subItem.initSubMenu(i, length);
            panel.add(subItem);
        }
        add(panel, indexZOrder + 1);
        revalidate();
        repaint();

    }
    
    private void hideMenu() {
    // ตรวจสอบว่ามีเมนูย่อย (panel) อยู่หรือไม่
        if (panel != null) {
        // ลบ panel ที่เก็บเมนูย่อยออกจาก JComponent (Menu)
            remove(panel);
            panel = null;  // รีเซ็ต panel
            revalidate();  // อัปเดต layout
            repaint();     // อัปเดตการแสดงผล
        }    
    }
    
    private void toggleSubMenu(MenuItem item, int index, int length) {
    // ตรวจสอบว่า panel มีอยู่แล้วหรือไม่
        if (panel == null) {
        // หากยังไม่มี panel (เมนูย่อย) ให้สร้างและแสดงเมนู
            addSubMenu(item, index, length, getComponentZOrder(item));
        } else {
        // หากมีเมนูย่อยแล้ว ให้ทำการซ่อนเมนู
            hideMenu();
        }
    }

    
}
