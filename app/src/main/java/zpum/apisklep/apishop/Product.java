package zpum.apisklep.apishop;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private int id;
    private String name;
    private String sellerName;
    private String descriiption;
    private Double price;



    public Product(int id, String name, String sellerName, String descriiption, Double price ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.descriiption = descriiption;
        this.sellerName = sellerName;
    }

}
