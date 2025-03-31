package StorageOrder;

import java.io.Serializable;

public class DataOrder extends Receipt implements Serializable {
    
    public DataOrder (String name, double price, int quantity,double total, double cash, String payment) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.cash = cash;
        this.payment = payment;
    }

}