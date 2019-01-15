package zpum.apisklep.apishop;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText password;
    Context context;
    public static final String MYURL = "https://shopwsb.azurewebsites.net";
    public String accessToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        login = findViewById(R.id.editLogin);
        password = findViewById(R.id.editPass);

    }

    public void Rejestracja(View view) {
        context = getApplicationContext();
        Intent rejestracja = new Intent(this, RejestracjaActivity.class);
        startActivity(rejestracja);
    }

    public void Menu(View view) {

        Service service = new Service(getApplicationContext());
        service.postLogin(login.getText().toString(), password.getText().toString());

        context = getApplicationContext();
        Intent menu = new Intent(this, MenuActivity.class);
        startActivity(menu);
    }

}
