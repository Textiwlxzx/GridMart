
package DataProduct.Essentials;

import static DataProduct.Drinks.StorageDrink.clearFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class StorageEss {
    
    
    private static ArrayList<Essentials> item = new ArrayList<>();
   
    
    public static void addItem(Essentials itemm) {
        item.add(itemm);
    }
    
    public static int getNumberOfEssentials() {
        return item.size();
    }
        
    public static ArrayList<Essentials> getAll() {
        return item;
    }
    
    public static void saveToFile() {
        
        
        try (FileWriter writer = new FileWriter("Essentials.txt")) {
            for (Essentials d : item) {
                writer.write(d.getName() + "," + d.getDescription() + "," + d.getCost() + "," + d.getPrice() + "," 
                        + d.getExp() + "," + d.getCategory() + "," + d.getImagePath() + "," + d.getLot() + "," + d.getQuantity() + "\n");
            }
            System.out.println("Data saved to file.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Essentials> loadFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("Essentials.txt"))) {
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
                    
                    Essentials d = new Essentials(name, description, cost, price, exp, cate, path, lot, quantity);
                      
                    boolean exists = false;
                    
                    for (Essentials existing : item) {
                        if (existing.getName().equals(d.getName())) {
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        item.add(d);
                    }
                    
                }
                
                line = reader.readLine();
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }
    
    public static void removeByName(String name) {
    Iterator <Essentials> iterator = item.iterator();
    
    while (iterator.hasNext()) {
        Essentials d = iterator.next();
        
        if (d.getName().equals(name)) {
            iterator.remove();
            System.out.println("Removed: " + d);
            return;
        }
    }
        System.out.println("Essentials with name '" + name + "' not found.");
    }
    
    public static void clearFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Essentials.txt"))) {
            writer.write("");
            System.out.println("File has been cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void EditData(String name , String newdes , Double newcost, Double newprice){
        for (Essentials d : item) {
            if (d.getName().equals(name)){
                d.setDescription(newdes);
                d.setCost(newcost);
                d.setPrice(newprice);
            }
        }
    }
    
    public static void resetExp(String name, String exp) {
        for (Essentials d : item) {
            if (d.getName().equals(name) && d.getExp().equals(exp)) {
                d.setExp("-");
                d.setQuantity(0);
            }
        }
    }
    
    public static void updateData(String lot, String name, int quantity, String exp) {
        for (Essentials d : item) {
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
