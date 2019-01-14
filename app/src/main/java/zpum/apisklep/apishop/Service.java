package zpum.apisklep.apishop;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static zpum.apisklep.apishop.MainActivity.MYURL;

public class Service {
    private final Context context;
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

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
                        setAccessToken(response.toString());
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
        ){
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

//    public void postLogin(final String logowanie) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//
//        StringRequest postLoginRequest = new StringRequest(
//                Request.Method.POST,  MYURL+"/user/login", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Toast.makeText(context, response, Toast.LENGTH_LONG).show();
//                Log.d("", response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        })
//       {
//           @Override
//           public Map<String, String> getHeaders() throws AuthFailureError {
//               Map<String, String> params = new HashMap<String, String>();
//               params.put("Content-Type", "application/json");
//               return params;
//           }
//            @Override
//            public String getBodyContentType() {
//                return "application/json; charset=utf-8";
//            }
//
//            @Override
//            public byte[] getBody() throws AuthFailureError {
//                try {
//                    return logowanie == null ? null :
//                            logowanie.getBytes("utf-8");
//                } catch (UnsupportedEncodingException uee) {
//                    return null;
//                }
//            }
//        };
//        queue.add(postLoginRequest);
//        queue.start();
//    }

//    public void postRejestracja(final String user) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//
//        StringRequest postRejestracjaRequest = new StringRequest(
//                Request.Method.POST, MYURL + "/user", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Toast.makeText(context, response, Toast.LENGTH_LONG).show();
//                Log.d("", response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Content-Type", "application/json");
//                return params;
//            }
//
//            @Override
//            public String getBodyContentType() {
//                return "application/json; charset=utf-8";
//            }
//
//            @Override
//            public byte[] getBody() throws AuthFailureError {
//                try {
//                    return user == null ? null :
//                            user.getBytes("utf-8");
//                } catch (UnsupportedEncodingException uee) {
//                    return null;
//                }
//            }
//        };
//        queue.add(postRejestracjaRequest);
//        queue.start();
//    }

}
