package Order;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderManager {
    private List<OrderList> orderLists;
    private JPanel orderListPanel;

    public OrderManager(JPanel orderListPanel) {
        this.orderListPanel = orderListPanel;
        this.orderLists = new ArrayList<>();
    }

    public void addOrderList(String productName) {
        OrderList orderList = new OrderList(productName);
        orderList.setProductName(productName);
        orderList.setParentPanel(orderListPanel);
        
        orderLists.add(orderList);
        orderListPanel.add(orderList);
        orderListPanel.revalidate();
        orderListPanel.repaint();
    }

    public void removeOrderList(OrderList orderList) {
        orderLists.remove(orderList);
        orderListPanel.remove(orderList);
        orderListPanel.revalidate();
        orderListPanel.repaint();
    }

    public List<OrderList> getAllOrderLists() {
        return new ArrayList<>(orderLists);
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (OrderList orderList : orderLists) {
            // Assuming you'll add a method to get the price of each order list
            // This is a placeholder and you'll need to implement the actual price calculation
            // total += orderList.getPrice() * orderList.getQuantity();
        }
        return total;
    }

    public void clearAllOrderLists() {
        orderLists.clear();
        orderListPanel.removeAll();
        orderListPanel.revalidate();
        orderListPanel.repaint();
    }

    public int getOrderListCount() {
        return orderLists.size();
    }
    public void saveOrderListsToFile() {
        // สร้างชื่อไฟล์แบบมี timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        String filename = "order_" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // เขียนส่วนหัว
            writer.write("Order Details");
            writer.newLine();
            writer.write("-------------------");
            writer.newLine();

            // เขียนรายละเอียดแต่ละ OrderList
            for (OrderList orderList : orderLists) {
                writer.write("Product: " + orderList.getLabelText4().getText());
                writer.newLine();
                writer.write("Quantity: " + orderList.getTextField2().getText());
                writer.newLine();
                writer.write("-------------------");
                writer.newLine();
            }

            // เขียนจำนวนออเดอร์ทั้งหมด
            writer.write("Total Orders: " + orderLists.size());
            writer.newLine();

            System.out.println("Order details saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving order details: " + e.getMessage());
        }
    }
}