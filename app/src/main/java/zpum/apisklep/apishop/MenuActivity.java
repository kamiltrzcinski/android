package zpum.apisklep.apishop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    }

    public void Wyswietl(View view){
        Service service = new Service(getApplicationContext());
        service.GetOffer();

        Intent wyswietl = new Intent(this, WyswietlActivity.class);
        startActivity(wyswietl);
    }
}
