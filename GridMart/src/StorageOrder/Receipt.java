package StorageOrder;

public abstract class Receipt {
    
    protected String name;
    protected double price;
    protected int quantity;
    protected double total;
    protected double cash;
    protected String payment;

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getCash() {
        return cash;
    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
