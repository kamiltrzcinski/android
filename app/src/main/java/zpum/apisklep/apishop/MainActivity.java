package zpum.apisklep.apishop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText password;
    Context context;
    public static final String MYURL = "https://shopwsb.azurewebsites.net";
    public String accessToken = "dupa";


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
        Logowanie logowanie = new Logowanie(login.getText().toString(), password.getText().toString());
//        final String url = MYURL+"/user/login";

        String logowanieJson = Utils.parseToJson(logowanie);
        Service service = new Service(getApplicationContext());
        service.postLogin(login.getText().toString(), password.getText().toString());
        accessToken = service.getAccessToken();

        context = getApplicationContext();
        Intent menu = new Intent(getBaseContext(), MenuActivity.class);
        startActivity(menu);
    }
}
