package DataProduct.Drinks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class StorageDrink {
    
    
    private static ArrayList<Drink> drinkItem = new ArrayList<>();
   
    
    public static void addItem(Drink item) {
        drinkItem.add(item);
    }
    
    public static int getNumberOfDrinks() {
        return drinkItem.size();
    }
        
    public static ArrayList<Drink> getAllDrinks() {
        return drinkItem;
    }
    
    public static void saveToFile() {
        
        
        try (FileWriter writer = new FileWriter("Drinks.txt")) {
            for (Drink d : drinkItem) {
                writer.write(d.getName() + "," + d.getDescription() + "," + d.getCost() + "," + d.getPrice() + "," 
                        + d.getExp() + "," + d.getCategory() + "," + d.getImagePath() + "," + d.getLot() + "," + d.getQuantity() + "\n");
            }
            System.out.println("Data saved to file.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Drink> loadFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("Drinks.txt"))) {
            String line;
            line = reader.readLine();
            while (line != null) {

                String[] data = line.split(",");
                if (data.length == 9) {
                    String name = data[0];
                    String description = data[1];
                    double cost = Double.parseDouble(data[2]);
                    double price = Double.parseDouble(data[3]);
                    String exp = data[4];
                    String cate = data[5];
                    String path = data[6];
                    String lot = data[7];
                    int quantity = Integer.parseInt(data[8]);
                    
                    Drink d = new Drink(name, description, cost, price, exp, cate, path, lot, quantity);
                    
                    boolean exists = false;
                    
                    for (Drink existingDrink : drinkItem) {
                        if (existingDrink.getName().equals(d.getName())) {
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        drinkItem.add(d);
                    }
                    
                }
                
                line = reader.readLine();
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drinkItem;
    }
    
    public static void removeByName(String name) {
    Iterator <Drink> iterator = drinkItem.iterator();
    
    while (iterator.hasNext()) {
        Drink drink = iterator.next();
        
        if (drink.getName().equals(name)) {
            iterator.remove();
            System.out.println("Removed: " + drink);
            return;
        }
    }
        System.out.println("Drink with name '" + name + "' not found.");
    }
    
    public static void clearFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Drinks.txt"))) {
            writer.write("");
            System.out.println("File has been cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void EditData(String name , String newdes , Double newcost, Double newprice){
        for (Drink d : drinkItem) {
            if (d.getName().equals(name)){
                d.setDescription(newdes);
                d.setCost(newcost);
                d.setPrice(newprice);
            }
        }
    }
    
    public static void resetExp(String name, String exp) {
        for (Drink d : drinkItem) {
            if (d.getName().equals(name) && d.getExp().equals(exp)) {
                d.setExp("-");
                d.setQuantity(0);
                d.setLot("");
            }
        }
    }
    
    public static void updateData(String lot, String name, int quantity, String exp) {
        for (Drink d : drinkItem) {
            if (d.getName().equals(name)) { //ไม่มีวันหมดอายุและจำนวนเริ่มต้นเป็น 0 (เริ่มต้น)
                if (!d.isExpProduct(exp) && d.getQuantity() == 0) {
                    d.setLot(lot);
                    d.setExp("-");
                    d.setQuantity(quantity);
                }
                else if (!d.isExpProduct(exp) && d.getQuantity() != 0) { //ไม่มีวันหมดอายุ แต่มีจำนวนอยู่แล้ว ให้บวกเพิ่มจำนวนเดิม
                    d.setLot(lot);
                    d.setExp("-");
                    d.setQuantity(d.getQuantity() + quantity);
                }
                else if (d.isExpProduct(exp) && d.getQuantity() == 0) { //สินค้ามีวันหมดอายุ และจำนวนเริ่มต้นเป็น 0 (เริ่มต้น)
                    d.setLot(lot);
                    d.setExp(exp);
                    d.setQuantity(quantity);
                }
                else if (d.isExpProduct(exp) && d.getLot().equals(lot)) { //สินค้ามีวันหมดอายุ แต่เพิ่ม lot เดียวกัน ให้บวกจำนวนของเดิม
                    d.setQuantity(d.getQuantity() + quantity);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        clearFile();
    }
}
