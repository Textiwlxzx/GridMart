/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Drinks;

import java.util.ArrayList;
import java.util.List;

public class StorageDrink {
    
    private static ArrayList<Drink> drinkItem = new ArrayList<>();
    
    public static void addItem(Drink item) {
        drinkItem.add(item);
    }
    
    /*public static Drink getDrinkItem(String key) {
        return drinkItem.get(key);
        
    }*/
    public static int getNumberOfDrinks() {
        return drinkItem.size();
    }
    
    public static Drink getLatestDrink() {
        if (!drinkItem.isEmpty()) {
            return drinkItem.get(drinkItem.size() - 1);  // ดึง Drink ตัวล่าสุด
        }
        return null;  // ถ้าไม่มีข้อมูลในลิสต์
    }
    
    public static List<Drink> getAllDrinks() {
        return new ArrayList<>(drinkItem);  // คืนค่าทั้งหมดใน ArrayList
    }
}
