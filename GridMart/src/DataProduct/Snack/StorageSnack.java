
package DataProduct.Snack;

import DataProduct.Drinks.Drink;
import static DataProduct.Drinks.StorageDrink.clearFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class StorageSnack {
    
    
    private static ArrayList<Snack> snackItem = new ArrayList<>();
   
    
    public static void addItem(Snack item) {
        snackItem.add(item);
    }
    
    public static int getNumberOfSnacks() {
        return snackItem.size();
    }
        
    public static ArrayList<Snack> getAllSnacks() {
        return snackItem;
    }
    
    public static void saveToFile() {
        
        
        try (FileWriter writer = new FileWriter("Snacks.txt")) {
            for (Snack d : snackItem) {
                writer.write(d.getName() + "," + d.getDescription() + "," + d.getCost() + "," + d.getPrice() + "," 
                        + d.getExp() + "," + d.getCategory() + "," + d.getImagePath() + "," + d.getLot() + "," + d.getQuantity() + "\n");
            }   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Snack> loadFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("Snacks.txt"))) {
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
                    
                    Snack d = new Snack(name, description, cost, price, exp, cate, path, lot, quantity);
                     
                    boolean exists = false;
                    
                    for (Snack existingDrink : snackItem) {
                        if (existingDrink.getName().equals(d.getName())) {
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        snackItem.add(d);
                    }
                    
                }
                
                line = reader.readLine();
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return snackItem;
    }
    
    public static void removeByName(String name) {
    Iterator <Snack> iterator = snackItem.iterator();
    
    while (iterator.hasNext()) {
        Snack snack = iterator.next();
        
        if (snack.getName().equals(name)) {
            iterator.remove();
            System.out.println("Removed: " + snack);
            return;
        }
    }
        System.out.println("Food with name '" + name + "' not found.");
    }
    
    public static void clearFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Snacks.txt"))) {
            writer.write("");
            System.out.println("File has been cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void EditData(String name , String newdes , Double newcost, Double newprice){
        for (Snack d : snackItem) {
            if (d.getName().equals(name)){
                d.setDescription(newdes);
                d.setCost(newcost);
                d.setPrice(newprice);
            }
        }
    }
    public static void resetExp(String name, String exp) {
        for (Snack d : snackItem) {
            if (d.getName().equals(name) && d.getExp().equals(exp)) {
                d.setExp("-");
                d.setQuantity(0);
                d.setLot("");
            }
        }
    }
    
    public static void updateData(String lot, String name, int quantity, String exp) {
        for (Snack d : snackItem) {
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
