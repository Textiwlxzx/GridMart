package DataProduct.Product;


public interface ExpirationDate {
    
    public abstract boolean isExpProduct(String exp);
    
    public abstract int getDaysUntilExp();
}
