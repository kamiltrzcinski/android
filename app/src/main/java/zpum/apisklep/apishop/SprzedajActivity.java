package zpum.apisklep.apishop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static zpum.apisklep.apishop.MainActivity.MYURL;

public class SprzedajActivity extends AppCompatActivity {

    EditText nazwa;
    EditText cena;
    EditText opis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprzedaj);

        nazwa = findViewById(R.id.editNazwa);
        cena = findViewById(R.id.editCena);
        opis = findViewById(R.id.editOpis);
    }

    public Product GetData() {
        String user = ActiveUser.getInstance().getUser().getLogin();
        Product product = new Product(nazwa.toString(), cena.toString(), opis.toString(), user);
        return product;
    }

    public void SendData(View view) {
        final String url = MYURL +"/";
        Product product = GetData();
    }

    public void Wyswietl(View view){
        Intent wyswietl = new Intent(this, WyswietlActivity.class);
        startActivity(wyswietl);
    }
}
