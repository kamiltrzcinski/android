package zpum.apisklep.apishop;

public class Logowanie {
    private String login;
    private String password;


    public String getLogin() {
        return login;
    }

    public String getPass() {
        return password;
    }

    public Logowanie(String login, String password){
        this.login = login;
        this.password = password;
    }
}
