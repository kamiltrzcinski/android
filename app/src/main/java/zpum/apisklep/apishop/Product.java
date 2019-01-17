package zpum.apisklep.apishop;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private int id;
    private String name;
    private String sellerName;
    private String description;
    private Double price;

    public int getId(){
        return id;
    }

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

    public Product(){}
    public Product(int id, String name, String sellerName, String description, Double price ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return
                "Nazwa Przedmiotu = " + name + "\n" +
                "Imię sprzedającego = " + sellerName + "\n" +
                "Cena = " + price;
    }
}
