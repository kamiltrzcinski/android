package zpum.apisklep.apishop;

import com.google.gson.Gson;

public class Utils {
    public static String parseToJson(Product product){
        return new Gson().toJson(product);
    }

    public static String parseToJson(User user){
        return new Gson().toJson(user);
    }

    public static String parseToJson(Logowanie logowanie) { return  new Gson().toJson(logowanie);}

    public static ApiToken parseFromJson(String apiToken){
        return new Gson().fromJson(apiToken, ApiToken.class);
    }

    public static String getMyToken(){
        return ActiveToken.getInstance().getApiToken().getAccessToken();
    }
}

