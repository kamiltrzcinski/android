package zpum.apisklep.apishop;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;

import static zpum.apisklep.apishop.MainActivity.MYURL;

public class Service {
    private final Context context;

    public Service(Context context) {
        this.context = context;
    }

    public void postLogin(final String login, final String password) {

        RequestQueue queue = Volley.newRequestQueue(context);
        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("login", login);
        jsonParams.put("password", password);


        Log.d("", "Json:" + new JSONObject(jsonParams));

        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, MYURL + "/user/login", new JSONObject(jsonParams),

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        ApiToken apiToken = Utils.parseFromJson(response.toString());
                        ActiveToken.getInstance().setApiToken(apiToken);
                        Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
                        Log.d("", response.toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
                        Log.d("", "Error: " + error
//                        + "\nStatus Code " + error.networkResponse.statusCode
//                        + "\nResponse Data " + error.networkResponse.data
                                + "\nCause " + error.getCause()
                                + "\nmessage" + error.getMessage());
                    }
                }

        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };

        queue.add(postRequest);
        queue.start();
    }

    public void postRejestracja(final String login, final String password, final String name,
                                final String surname, final String premise, final String street,
                                final String postCode, final String city, final String country) {
        RequestQueue queue = Volley.newRequestQueue(context);
        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("login", login);
        jsonParams.put("password", password);
        jsonParams.put("name", name);
        jsonParams.put("surname", surname);
        jsonParams.put("premise", premise);
        jsonParams.put("street", street);
        jsonParams.put("postCode", postCode);
        jsonParams.put("city", city);
        jsonParams.put("country", country);

        Log.d("", "JSON: " + new JSONObject(jsonParams));

        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, MYURL + "/user",
                new JSONObject(jsonParams), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
                        Log.d("", "Error: " + error
//                        + "\nStatus Code " + error.networkResponse.statusCode
//                        + "\nResponse Data " + error.networkResponse.data
                                + "\nCause " + error.getCause()
                                + "\nmessage" + error.getMessage());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };
        queue.add(postRequest);
        queue.start();
    }

    public void postOffer(final String name, final String sellerName, final String description, final Double price) {

        RequestQueue queue = Volley.newRequestQueue(context);
        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("name", name);
        jsonParams.put("sellerName", sellerName);
        jsonParams.put("description", description);
        jsonParams.put("price", price.toString());


        Log.d("", "Json:" + new JSONObject(jsonParams));

        JsonObjectRequest putRequest = new JsonObjectRequest(Request.Method.POST, MYURL + "/offer", new JSONObject(jsonParams),

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
                        Log.d("", "Error: " + error
//                        + "\nStatus Code " + error.networkResponse.statusCode
//                        + "\nResponse Data " + error.networkResponse.data
                                + "\nCause " + error.getCause()
                                + "\nmessage" + error.getMessage());
                    }
                }

        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", Utils.getMyToken());
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };

        queue.add(putRequest);
        queue.start();
    }

    public void GetAllOffer() {
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest getAllRequest = new JsonArrayRequest(Request.Method.GET, MYURL + "/offer", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject product = response.getJSONObject(i);

                        int id = product.getInt("id");
                        String name = product.getString("name");
                        String sellerName = product.getString("sellerName");
                        String description = product.getString("description");
                        Double price = product.getDouble("price");

                        Product finalProduct = new Product(id, name, sellerName, description, price);

                        Toast.makeText(context, id+" "+name+" "+sellerName+" "+description+" "+price.toString()+"\n",Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("", "Error: " + error
//                        + "\nStatus Code " + error.networkResponse.statusCode
//                        + "\nResponse Data " + error.networkResponse.data
                        + "\nCause " + error.getCause()
                        + "\nmessage" + error.getMessage());
            }
        }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", Utils.getMyToken());
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };

        queue.add(getAllRequest);
        queue.start();
    }
}
