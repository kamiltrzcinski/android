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
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import android.content.SharedPreferences;

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
                        Toast.makeText(context, "Zalogowano poprawnie!", Toast.LENGTH_LONG).show();
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
                Toast.makeText(context, "Zarejestrowano poprawnie!", Toast.LENGTH_LONG).show();
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

        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, MYURL + "/offer", new JSONObject(jsonParams),

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(context, "Przedmiot wystawiono do sprzedaży!", Toast.LENGTH_LONG).show();
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

        queue.add(postRequest);
        queue.start();
    }

    public void GetAllOffer(final VolleyCallback callback) {
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest getAllRequest = new JsonArrayRequest(Request.Method.GET, MYURL + "/offer", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                callback.onSuccess(response.toString());
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

    public void GetOffer(int position, final VolleyCallback callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        position += 1;
        String id = String.valueOf(position);
        JsonObjectRequest getOfferRequest = new JsonObjectRequest(Request.Method.GET, MYURL + "/offer/" + id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                callback.onSuccess(response.toString());
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
        }) {
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
        queue.add(getOfferRequest);
        queue.start();
    }

    public void putOffer(int position, final String name, final String sellerName, final String description, final Double price) {

        RequestQueue queue = Volley.newRequestQueue(context);
        String id = String.valueOf(position);
        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("name", name);
        jsonParams.put("sellerName", sellerName);
        jsonParams.put("description", description);
        jsonParams.put("price", price.toString());


        Log.d("", "Json:" + new JSONObject(jsonParams));

        JsonObjectRequest putRequest = new JsonObjectRequest(Request.Method.PUT, MYURL + "/offer/" + id, new JSONObject(jsonParams),

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(context, "Zmieniono przedmiot!", Toast.LENGTH_LONG).show();
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

    public void deleteOffer(int position) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String id = String.valueOf(position);

        JsonObjectRequest deleteRequest = new JsonObjectRequest(Request.Method.DELETE, MYURL + "/delete/offer/" + id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context, "Przedmiot usunięto!", Toast.LENGTH_LONG).show();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
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

        queue.add(deleteRequest);
        queue.start();
    }
}
