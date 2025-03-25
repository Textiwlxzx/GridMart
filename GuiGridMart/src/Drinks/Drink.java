package Drinks;

import javax.swing.*;

public class Drink extends Product {
    
    private JPanel panelDrink;
    
    public Drink() {
        
    }
    
    public Drink(String name, String description, double cost, double price) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
        this.quantity = 0;
        
    }
}
