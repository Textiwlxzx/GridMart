
package DataProduct.Snack;

import DataProduct.Product.AboutExp;
import DataProduct.Product.ExpirationDate;
import DataProduct.Product.Product;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Snack extends Product implements ExpirationDate, Serializable {
    
    private int daysLeft;
    
    public Snack(String name, String description, double cost, double price, String cate, String path) {
        this(name, description, cost, price, "-", cate, path, "-", 0);
    }
    
    public Snack(String name, String description, double cost, double price, String exp, String cate, String path) {
        this(name, description, cost, price, exp, cate, path, "-", 0);
    }
    
    public Snack(String name, String description, double cost, double price, String exp, String cate, String path, String lot, int quantity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
        this.exp = exp;
        this.category = cate;
        this.imagePath = path;
        this.lot = lot;
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "Drink{name='" + name + "', description='" + description + "', cost=" + cost + ", price=" + price + "}";
    }

    @Override
    public boolean isExpProduct(String exp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            sdf.parse(exp);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public int getDaysUntilExp() {
        return daysLeft = AboutExp.calDayLeftExp(name, exp);    
    }
    
    @Override
    public double profitPerEach() {
        double diffEach = price - cost;
        return diffEach;
    }
}
