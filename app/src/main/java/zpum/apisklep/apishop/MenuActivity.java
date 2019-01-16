package zpum.apisklep.apishop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONObject;

public class MenuActivity extends AppCompatActivity {

    String value = ActiveToken.getInstance().getApiToken().getAccessToken();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }



    public void Sprzedaj(View view) {
        Intent sprzedaj = new Intent(this, SprzedajActivity.class);
        startActivity(sprzedaj);
        this.recreate();
    }

    public void Wyswietl(View view){
        final Context context = getApplicationContext();
        Service service = new Service(getApplicationContext());
        service.GetAllOffer(new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Product[] tablica = new Gson().fromJson(result, Product[].class);
//                Product[] tablica = new Product[result.length()-1];
                Intent intent = new Intent(context, WyswietlActivity.class);
                intent.putExtra("tablica", tablica);
                startActivity(intent);
            }
        });
//        Intent intent = new Intent(this, WyswietlActivity.class);
//        intent.putExtra("tablica", );
//        startActivity(intent);
        this.recreate();
    }
}
