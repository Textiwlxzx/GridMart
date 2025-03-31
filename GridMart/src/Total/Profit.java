package Total;

import DataProduct.Product.Product;


public class Profit {

    private static double profitPerProduct = 0;

    public static double calProfitPerProduct(Product p, int quantity) {
        profitPerProduct = p.profitPerEach() * quantity;
        return profitPerProduct;
    }
}