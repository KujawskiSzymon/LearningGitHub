package api;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Integer getProductsCount();
    Product getProductByName(String productName);
    Boolean isProductOnWarehouse (String productName);
    Boolean isProductExists(String productName);
    Boolean isProductExists (Long productId);


}
