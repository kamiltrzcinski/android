package zpum.apisklep.apishop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

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
        Intent wyswietl = new Intent(this, WyswietlActivity.class);
        startActivity(wyswietl);
    }
}
