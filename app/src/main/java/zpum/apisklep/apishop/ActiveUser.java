package zpum.apisklep.apishop;

public class ActiveUser {
    private User user;

    private static final ActiveUser ourInstance = new ActiveUser();

    public static ActiveUser getInstance() {
        return ourInstance;
    }

    private ActiveUser() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
