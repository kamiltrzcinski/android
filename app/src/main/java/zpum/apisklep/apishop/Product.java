package zpum.apisklep.apishop;

public class Product {

    private String name;
    private String sellerName;
    private String descriiption;
    private Double price;

    public Product(String name, String sellerName, String descriiption, Double price ) {
        this.name = name;
        this.price = price;
        this.descriiption = descriiption;
        this.sellerName = sellerName;
    }

}
