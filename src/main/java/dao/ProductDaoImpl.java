package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    String fileName;
    String productType;
    public ProductDaoImpl(String fileName, String productType) throws IOException {
        this.fileName = fileName;
        this.productType = productType;
        FileUtils.createNewFile(fileName);
    }

    public void saveProduct(Product product) throws IOException {
            List<Product> products = getAllProducts();
            products.add(product);
            saveProducts(products);
    }

    public void saveProducts(List<Product> products) throws FileNotFoundException {
        clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName,true));
        for(Product product: products){
            printWriter.write(product.toString()+"\n");
        }
        printWriter.close();

    }

    public void clearFile(String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(fileName);
        pw.close();

    }

    public void removeProductById(Long id) throws IOException {
            List<Product> products =getAllProducts();
            for(int i=0;i<products.size();i++){
                boolean isFound = products.get(i).getId().equals(id);
                if(isFound){
                    products.remove(i);
                }
            }
            saveProducts(products);
    }

    public void removeProductByName(String filename) throws IOException {
        List<Product> products =getAllProducts();
        for(int i=0;i<products.size();i++){
            boolean isFound = products.get(i).getProductName().equals(filename);
            if(isFound){
                products.remove(i);
            }
        }
        saveProducts(products);
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String readLine = bufferedReader.readLine();
        while (readLine!=null){

            Product product = ProductParser.stringToProduct(readLine, productType);
            if (product != null) {
                products.add(product);
            }

        }
        bufferedReader.close();
        return products;
    }

    public Product getProductById(Long id) throws IOException {
        List<Product> products = getAllProducts();
        for(Product product: products){
            boolean found = product.getId().equals(id);
            if(found)
                return product;
        }
        return null;
    }

    public Product getProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        for(Product product: products){
            boolean found = product.getProductName().equals(productName);
            if(found)
                return product;
        }
        return null;
    }

}
