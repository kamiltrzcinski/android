package zpum.apisklep.apishop;

public class Product {

    private String nazwa;
    private String cena;
    private String opis;
    private String user;

    public String getNazwa() {
        return nazwa;
    }

    public String getCena() {
        return cena;
    }

    public String getOpis() {
        return opis;
    }

    public String getUser(){
        return user;
    }

    public Product(String nazwa, String cena, String opis, String user) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.opis = opis;
        this.user = user;
    }

}
