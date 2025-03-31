
package DataProduct.Others;

import static DataProduct.Drinks.StorageDrink.clearFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class StorageOthers {
    
    
    private static ArrayList<Others> othersItem = new ArrayList<>();
   
    
    public static void addItem(Others item) {
        othersItem.add(item);
    }
    
    public static int getNumberOfOthers() {
        return othersItem.size();
    }
        
    public static ArrayList<Others> getAll() {
        return othersItem;
    }
    
    public static void saveToFile() {
        
        
        try (FileWriter writer = new FileWriter("Others.txt")) {
            for (Others d : othersItem) {
                writer.write(d.getName() + "," + d.getDescription() + "," + d.getCost() + "," + d.getPrice() + "," 
                        + d.getExp() + "," + d.getCategory() + "," + d.getImagePath() + "," + d.getLot() + "," + d.getQuantity() + "\n");
            }
            System.out.println("Data saved to file.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Others> loadFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("Others.txt"))) {
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
                    
                    Others d = new Others(name, description, cost, price, exp, cate, path, lot, quantity);
                    
                    boolean exists = false;
                    
                    for (Others existingDrink : othersItem) {
                        if (existingDrink.getName().equals(d.getName())) {
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        othersItem.add(d);
                    }
                    
                }
                
                line = reader.readLine();
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return othersItem;
    }
    
    public static void removeByName(String name) {
    Iterator <Others> iterator = othersItem.iterator();
    
    while (iterator.hasNext()) {
        Others others = iterator.next();
        
        if (others.getName().equals(name)) {
            iterator.remove();
            System.out.println("Removed: " + others);
            return;
        }
    }
        System.out.println("Others with name '" + name + "' not found.");
    }
    
    public static void clearFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Others.txt"))) {
            writer.write("");
            System.out.println("File has been cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void EditData(String name , String newdes , Double newcost, Double newprice){
        for (Others d : othersItem) {
            if (d.getName().equals(name)){
                d.setDescription(newdes);
                d.setCost(newcost);
                d.setPrice(newprice);
            }
        }
    }
    
    public static void resetExp(String name, String exp) {
        for (Others d : othersItem) {
            if (d.getName().equals(name) && d.getExp().equals(exp)) {
                d.setExp("-");
                d.setQuantity(0);
            }
        }
    }
    
    public static void updateData(String lot, String name, int quantity, String exp) {
        for (Others d : othersItem) {
            if (d.getName().equals(name)) {
                if (!d.isExpProduct(exp) && d.getQuantity() == 0) {
                    d.setLot(lot);
                    d.setExp("-");
                    d.setQuantity(quantity);
                }
                else if (!d.isExpProduct(exp) && d.getQuantity() != 0) {
                    d.setLot(lot);
                    d.setExp("-");
                    d.setQuantity(d.getQuantity() + quantity);
                }
                else if (d.isExpProduct(exp) && d.getQuantity() == 0) {
                    d.setLot(lot);
                    d.setExp(exp);
                    d.setQuantity(quantity);
                }
                else if (d.isExpProduct(exp) && d.getLot().equals(lot)) {
                    d.setQuantity(d.getQuantity() + quantity);
                }
            }
        }
    }
    public static void main(String[] args) {
        clearFile();
    }
}
