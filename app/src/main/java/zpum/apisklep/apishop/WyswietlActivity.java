package zpum.apisklep.apishop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WyswietlActivity extends AppCompatActivity {

    @BindView(R.id.productNameT)
    TextView productNameT;
    @BindView(R.id.sellerNameT)
    TextView sellerNameT;
    @BindView(R.id.priceT)
    TextView priceT;
    @BindView(R.id.menuButton)
    Button menuButton;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyswietl);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.menuButton)
    public void onViewClicked() {
        context = getApplicationContext();
        Intent menu = new Intent(this, MenuActivity.class);
        startActivity(menu);
    }
}
