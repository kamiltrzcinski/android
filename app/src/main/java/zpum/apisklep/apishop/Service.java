package zpum.apisklep.apishop;

import android.app.VoiceInteractor;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;

import static zpum.apisklep.apishop.MainActivity.MYURL;

public class Service {
    private final Context context;

    public Service(Context context) {
        this.context = context;
    }

    public void postLogin(final String logowanie) {
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest postLoginRequest = new StringRequest(
                Request.Method.POST, MYURL+"/user/login", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Zalogowano", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
//        {
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
        queue.add(postLoginRequest);
        queue.start();
    }

    public void postRejestracja(final String user) {
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest postRejestracjaRequest = new StringRequest(
                Request.Method.POST, MYURL+"/user", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Zarejestrowano", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
//        {
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
        queue.add(postRejestracjaRequest);
        queue.start();
    }
}
