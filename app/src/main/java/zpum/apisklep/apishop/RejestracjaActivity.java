package zpum.apisklep.apishop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static zpum.apisklep.apishop.MainActivity.MYURL;

public class RejestracjaActivity extends AppCompatActivity {

    EditText login;
    EditText password;
    EditText name;
    EditText surname;
    EditText premise;
    EditText street;
    EditText postCode;
    EditText city;
    EditText country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);

        login = findViewById(R.id.editLogin1);
        password = findViewById(R.id.editPass1);
        name = findViewById(R.id.editImie);
        surname = findViewById(R.id.editNazwisko);
        premise = findViewById(R.id.editNrDom);
        street = findViewById(R.id.editUlica);
        postCode = findViewById(R.id.editKod);
        city = findViewById(R.id.editMiasto);
        country = findViewById(R.id.editPanstwo);
    }

    public void SendData(View view) {
        Service service = new Service(getApplicationContext());
            service.postRejestracja(login.getText().toString(), password.getText().toString(),
                    name.getText().toString(), surname.getText().toString(), premise.getText().toString(),
                    street.getText().toString(), postCode.getText().toString(), city.getText().toString(),
                    country.getText().toString());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.recreate();
    }
}
