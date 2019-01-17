package zpum.apisklep.apishop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SprzedajActivity extends AppCompatActivity {


    @BindView(R.id.productNameTE)
    EditText productNameTE;
    @BindView(R.id.sellerNameTE)
    EditText sellerNameTE;
    @BindView(R.id.descriptionProductET)
    EditText descriptionProductET;
    @BindView(R.id.priceET)
    EditText priceET;
    @BindView(R.id.sellButton)
    Button sellButton;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprzedaj);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.sellButton)
    public void onViewClicked() {
        Service service = new Service(getApplicationContext());
        if (priceET.getText().toString().equals("") || productNameTE.getText().toString().equals("") || descriptionProductET.getText().equals("")) {
            Toast.makeText(this, "Musisz wprowadzić wszystkie dane!", Toast.LENGTH_LONG).show();
        } else {
            service.postOffer(productNameTE.getText().toString(), sellerNameTE.getText().toString(), descriptionProductET.getText().toString(), Double.parseDouble(priceET.getText().toString()));
        }
        context = getApplicationContext();
        Intent menu = new Intent(this, MenuActivity.class);
        startActivity(menu);
        this.recreate();
    }
}
