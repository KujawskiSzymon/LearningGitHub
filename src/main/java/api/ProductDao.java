package api;

import entity.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductDao {
    void saveProduct(Product product) throws IOException;
    void saveProducts(List<Product> products) throws FileNotFoundException;
    void removeProductById(Long id) throws IOException;
    void removeProductByName(String filename) throws  IOException;
    List<Product> getAllProducts() throws IOException;
    Product getProductById(Long id) throws IOException;
    Product getProductByName(String productName) throws IOException;
}
