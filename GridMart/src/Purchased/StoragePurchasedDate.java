
package Purchased;

import DataProduct.Snack.Snack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StoragePurchasedDate {
    
    public static ArrayList<AddStockData> data = new ArrayList<>();
   
    public static void addItem(AddStockData item) {
        data.add(item);
    }
    
    public static ArrayList<AddStockData> getAllStockData() {
        return data;
    }
    
    public static void saveToFile() {
        
        try (FileWriter writer = new FileWriter("PurchasedData.txt")) {
            for (AddStockData d : data) {
                writer.write(d.getDate() + "," + d.getName() + "," + d.getQuantity() + "\n");
            }   
            System.out.println("saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<AddStockData> loadFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("PurchasedData.txt"))) {
            String line;
            line = reader.readLine();
            while (line != null) {
                String[] item = line.split(",");
                if (item.length == 3) {
                    String date = item[0];
                    String name = item[1];
                    int quantity = Integer.parseInt(item[2]);
                    
                    AddStockData d = new AddStockData(date, name, quantity); 

                    data.add(d);
                }
                line = reader.readLine();
            }
            System.out.println("Data loaded successfully.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public static void clearFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PurchasedData.txt"))) {
            writer.write("");
            System.out.println("File has been cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void clearPurchased(){
        data.clear();
    }

    public static void main(String[] args) {
        clearPurchased();
        clearFile();
    }
}
