import api.ProductService;
import api.UserService;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import  service.ProductServiceImpl;
public class ProductServiceTest  {

    @Test
    public void getAllProductsTest(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        products.add(new Boots(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl userService = new ProductServiceImpl(products);
        List<Product> listFromTestClass = userService.getAllProducts();

        Assert.assertEquals(products, listFromTestClass);
    }
    @Test
    public void GetCountProductWithProductsTest(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l,"T-SHIRT",35,0.3f,"Black",4,"XL","COTTON"));
        products.add(new Boots(2l,"Boots",25,0.3f,"Black",4,38,true));

        ProductServiceImpl productService = new ProductServiceImpl();
        final int result = productService.getProductsCount();
    }
    @Test
    public void GetProductsByProductNameWhenNoExsitsTest(){
        List<Product> products = new ArrayList<Product>();
        Product cloth =  new Cloth(1l,"T-SHIRT",35,0.3f,"Black", 4,"XL","COTTON");
        products.add(cloth);
        products.add(new Boots(2l,"Boots",25,0.3f,"Black",4,38,true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByName("JAKIS-PRODUKT");
        Assert.assertEquals(null,product);

    }

    @Test
    public void IsProductOnStockWhenNotTest(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l,"Boots",25,0.3f,"Black",0,38,true));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnStock = productService.isProductOnWarehouse("Boots");
        Assert.assertFalse(isProductOnStock);
    }
    @Test
    public void IsProductExistByIdWhenNotTest(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l,"Boots",25,0.3f,"Black",0,38,true));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExists(5l);
        Assert.assertFalse(isProductExist);
    }

}
