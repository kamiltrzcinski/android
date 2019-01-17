package zpum.apisklep.apishop;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private int id;
    private String name;
    private String sellerName;
    private String description;
    private Double price;

    public String getName() {
        return name;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Product(int id, String name, String sellerName, String description, Double price ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
