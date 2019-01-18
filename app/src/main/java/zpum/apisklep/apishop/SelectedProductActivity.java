package zpum.apisklep.apishop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectedProductActivity extends AppCompatActivity {

    @BindView(R.id.productName)
    TextView productName;
    @BindView(R.id.sellerName)
    TextView sellerName;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.menuButton)
    Button menuButton;
    @BindView(R.id.deleteButton)
    Button deleteButton;
    @BindView(R.id.updateButton)
    Button updateButton;
    @BindView(R.id.productNameTE)
    EditText productNameTE;
    @BindView(R.id.sellerNameET)
    EditText sellerNameET;
    @BindView(R.id.descriptionET)
    EditText descriptionET;
    @BindView(R.id.priceET)
    EditText priceET;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_product);
        ButterKnife.bind(this);
        String result = getIntent().getStringExtra("produkt");
        Product product = new Gson().fromJson(result, Product.class);
        productName.setText(product.getName());
        sellerName.setText(product.getSellerName());
        description.setText(product.getDescription());
        price.setText(product.getPrice().toString());
        id=product.getId();
    }

    @OnClick({R.id.menuButton, R.id.deleteButton, R.id.updateButton})
    public void onViewClicked(View view) {

        Service service = new Service(getApplicationContext());

        switch (view.getId()) {
            case R.id.menuButton:
                break;
            case R.id.deleteButton:
                service.deleteOffer(id);
                break;
            case R.id.updateButton:
                if(productName.getText().toString().equals("") || sellerNameET.getText().toString().equals("") || descriptionET.getText().toString().equals("") || priceET.getText().toString().equals("")){
                    Toast.makeText(this, "Musisz wprowadzić wszystkie dane!", Toast.LENGTH_LONG).show();
                }else {
                    service.putOffer(id, productNameTE.getText().toString(), sellerName.getText().toString(), descriptionET.getText().toString(), Double.parseDouble(priceET.getText().toString()));
                }
                break;
        }
        Intent menu = new Intent(this, MenuActivity.class);
        startActivity(menu);
        this.recreate();
    }
}
