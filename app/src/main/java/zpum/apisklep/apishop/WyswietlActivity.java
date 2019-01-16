package zpum.apisklep.apishop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WyswietlActivity extends AppCompatActivity {


    @BindView(R.id.menuButton)
    Button menuButton;
    @BindView(R.id.productT)
    TextView productT;

//    String result = getIntent().getStringExtra("tablica");
//    Product[] products = new Gson().fromJson(result, Product[].class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyswietl);
        ButterKnife.bind(this);
        String result = getIntent().getStringExtra("tablica");
        Product[] products = new Gson().fromJson(result, Product[].class);
        for (int i=0; i<products.length; i++){
            productT.setText(products[i]+"");
        }
    }


    @OnClick({R.id.menuButton, R.id.productT})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.menuButton:
                break;
            case R.id.productT:
                break;
        }
    }
}
