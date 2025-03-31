
package Purchased;

public class AddStockData {
    
    private String date;
    private String name;
    private int quantity;
    
    public AddStockData(String date, String name, int quantity) {
        this.date = date;
        this.name = name;
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
