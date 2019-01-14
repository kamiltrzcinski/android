package zpum.apisklep.apishop;

public class ActiveToken {
    private ApiToken apiToken = new ApiToken();

    private static final ActiveToken ourInstance = new ActiveToken();

    public static ActiveToken getInstance() {
        return ourInstance;
    }

    private ActiveToken() {
    }

    public ApiToken getApiToken() {
        return apiToken;
    }

    public void setApiToken(ApiToken apiToken) {
        this.apiToken = apiToken;
    }
}
