package entity;

public class Product {
    protected long id;
    protected String productName;
    protected  double price;
    protected  double weight;
    protected  String color;
    protected  int productCount;
    public final static String PRODUCT_SEPARATOR = "#";

    public Product(long id, String productName, double price, double weight, String color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public Product() {
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    @Override
    public String toString() {
        return id + PRODUCT_SEPARATOR + productName + PRODUCT_SEPARATOR +
                price + PRODUCT_SEPARATOR + weight + PRODUCT_SEPARATOR + color + PRODUCT_SEPARATOR + productCount;
    }
}
