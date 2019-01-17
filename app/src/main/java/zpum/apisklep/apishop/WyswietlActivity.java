package zpum.apisklep.apishop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class WyswietlActivity extends AppCompatActivity {
    @BindView(R.id.menuButton)
    Button menuButton;
    @BindView(R.id.productList)
    ListView productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyswietl);
        ButterKnife.bind(this);
        String result = getIntent().getStringExtra("tablica");
        Product[] products = new Gson().fromJson(result, Product[].class);

        ArrayAdapter<Product> productsAdapter = new ArrayAdapter<Product>
                (this, R.layout.product, R.id.textView, products);

        productList.setAdapter(productsAdapter);
    }

    @OnClick(R.id.menuButton)
    public void onViewClicked() {
        Intent menu = new Intent(this, MenuActivity.class);
        startActivity(menu);
        this.recreate();
    }

    @OnItemClick(R.id.productList)
    public void onItemClick(AdapterView<?> parent, final int position){

        final Context context = getApplicationContext();
        Service service = new Service(getApplicationContext());
        service.GetOffer(position, new VolleyCallback() {
            @Override
            public void onSuccess(String result) {
                Intent intent = new Intent(context, SelectedProductActivity.class);
                intent.putExtra("produkt", result);
                startActivity(intent);
            }
        });
        this.recreate();
    }
}

