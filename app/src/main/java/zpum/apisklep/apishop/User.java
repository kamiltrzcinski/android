package zpum.apisklep.apishop;

public class User {
    private String login;
    private String password;
    private String name;
    private String surname;
    private String premise;
    private String street;
    private String postCode;
    private String city;
    private String country;


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPremise() {
        return premise;
    }

    public String getStreet() {
        return street;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public User(String login, String password, String name, String surname, String premise,
                String street, String postCode, String city,
                String panstwo){
        this.login=login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.premise = premise;
        this.street = street;
        this.postCode = postCode;
        this.city = city;
        this.country =panstwo;
    }
}
