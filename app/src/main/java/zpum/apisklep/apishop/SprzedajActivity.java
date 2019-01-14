package zpum.apisklep.apishop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static zpum.apisklep.apishop.MainActivity.MYURL;

public class SprzedajActivity extends AppCompatActivity {

    @BindView(R.id.editNazwa)
    EditText editNazwa;
    @BindView(R.id.editCena)
    EditText editCena;
    @BindView(R.id.editOpis)
    EditText editOpis;
    @BindView(R.id.buttonSprzedaj)
    Button buttonSprzedaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprzedaj);
        ButterKnife.bind(this);

    }

    public Product GetData() {
        String user = ActiveUser.getInstance().getUser().getLogin();
        Product product = new Product(editNazwa.toString(), editCena.toString(), editOpis.toString(), user);
        return product;
    }

    public void SendData(View view) {
        final String url = MYURL + "/";
        Product product = GetData();
    }

    public void Wyswietl(View view) {
        Intent wyswietl = new Intent(this, WyswietlActivity.class);
        startActivity(wyswietl);
    }

    @OnClick(R.id.buttonSprzedaj)
    public void onViewClicked() {
    }
}
