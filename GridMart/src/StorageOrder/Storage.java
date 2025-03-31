package StorageOrder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Storage {

    private static ArrayList<DataOrder> dataOrder = new ArrayList<>();

    private static Map<Integer, ArrayList<DataOrder>> dataReceipt = new HashMap<>();
    
    public static void addItem(DataOrder item) {
        dataOrder.add(item);
    }
    
    public static void addReceipt(Integer orderno,ArrayList<DataOrder> item) {
        dataReceipt.put(orderno,item);
    }

    public static int getNumberOfDataOrder() {
        return dataOrder.size();
    }

    public static ArrayList<DataOrder> getAllDataOrder() {
        return dataOrder;
    }
    
    public static Map<Integer, ArrayList<DataOrder>> getAllDataReceipt() {
        return dataReceipt;
    }
    
    public static void saveToFile() {
        
        try (FileWriter writer = new FileWriter("DataOrder.txt")) {
            for (DataOrder d : dataOrder) {
                writer.write(d.getName() + "," + d.getPrice() + "," + d.getQuantity() + "," + d.getTotal()+ "," + d.getCash() + "," + d.getPayment() + "\n");
            }
            System.out.println("Data saved to file.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveToFileReceipt() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dataReceipt.txt"))) {
            for (Map.Entry<Integer, ArrayList<DataOrder>> entry : dataReceipt.entrySet()) {
                int orderNo = entry.getKey();
                ArrayList<DataOrder> items = entry.getValue();
                double total = 0.0;

                writer.write(orderNo + "|");

                for (int i = 0; i < items.size(); i++) {
                    DataOrder item = items.get(i);

                    if (item.getName().equals("Total")) {
                        total = item.getPrice();
                    } else {
                        writer.write(item.getName() + "," + item.getPrice() + "," + item.getQuantity()+ "," + item.getQuantity() * item.getPrice() + "," + item.getCash() + "," + item.getPayment());
                        if (i < items.size() - 1) writer.write("|");
                    }
                }

                writer.newLine();
            }
            System.out.println("SavedataRecceipt Succes");
        } catch (IOException e) {
            System.out.println("❌ Error: ไม่สามารถบันทึกไฟล์ได้");
            e.printStackTrace();
        }
    }


    
    public static ArrayList<DataOrder> loadFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("DataOrder.txt"))) {
            dataReceipt.clear();
            String line;
            line = reader.readLine();
            while (line != null) {

                String[] data = line.split(",");
                if (data.length == 5) {
                    String name = data[0];
                    double price = Double.parseDouble(data[1]);
                    int quantity = Integer.parseInt(data[2]);
                    double total = Double.parseDouble(data[3]);
                    double cash = Double.parseDouble(data[4]);
                    String payment = data[5];

                    DataOrder d = new DataOrder(name, price, quantity, total, cash,payment);
                    
                    boolean exists = false;
                    
                    for (DataOrder existingData : dataOrder) {
                        if (existingData.getName().equals(d.getName())) {
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        dataOrder.add(d);
                    }
                    
                }
                
                line = reader.readLine();
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataOrder;
    }
    
    public static void loadFromFileReceipt() {
        try (BufferedReader reader = new BufferedReader(new FileReader("dataReceipt.txt"))) {
            dataReceipt.clear();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int orderNo = Integer.parseInt(parts[0]);

                ArrayList<DataOrder> items = new ArrayList<>();

                for (int i = 1; i < parts.length; i++) {
                    String[] itemDetails = parts[i].split(",");


                    String name = itemDetails[0];
                    double price = Double.parseDouble(itemDetails[1]);
                    int quantity = Integer.parseInt(itemDetails[2]);
                    double total = Double.parseDouble(itemDetails[3]);
                    double cash = Double.parseDouble(itemDetails[4]);
                    String payment = itemDetails[5];

                    items.add(new DataOrder(name, price, quantity, total, cash, payment));
                }

                dataReceipt.put(orderNo, items);
            }

            System.out.println("DataLoadSucces " + "dataReceipt.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeByName(String name) {
        Iterator <DataOrder> iterator = dataOrder.iterator();
    
        while (iterator.hasNext()) {
            DataOrder data = iterator.next();

            if (data.getName().equals(name)) {
                iterator.remove();
                System.out.println("Removed: " + data);
                return;
            }
        }
        System.out.println("Drink with name '" + name + "' not found.");
    }
    
    public static void EditQuantity(String name , int quantity){
        for (DataOrder d : dataOrder) {
            if (d.getName().equals(name)){
                d.setQuantity(quantity);
            }
        }
    }
    
    public static void clearFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DataOrder.txt"))) {
            writer.write("");
            dataOrder.clear();
            System.out.println("File has been cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void clearFileReceipt() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dataReceipt.txt"))) {
            writer.write("");
            System.out.println("File has been cleared.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static int getLastOrderNumber() {
        int lastOrder = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("dataReceipt.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int orderNo = Integer.parseInt(parts[0]);

                if (orderNo > lastOrder) {
                    lastOrder = orderNo;
                }
            }

        } catch (IOException e) {
            System.out.println("❌ Error: " + "dataReceipt.txt");
            e.printStackTrace();
        }

        return lastOrder;
    }
    
    public static void EditPayment(String name , String payment){
        for (DataOrder d : dataOrder) {
            if (d.getName().equals(name)){
                d.setPayment(payment);
            }
        }
    }
    
    public static void main(String[] args) {
        clearFile();
        clearFileReceipt();
    }
}
