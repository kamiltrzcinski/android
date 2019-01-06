package zpum.apisklep.apishop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static zpum.apisklep.apishop.MainActivity.MYURL;

public class RejestracjaActivity extends AppCompatActivity {

    EditText login;
    EditText pass;
    EditText imie;
    EditText nazwisko;
    EditText ulica;
    EditText nrDom;
    EditText kod;
    EditText miasto;
    EditText panstwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);

        login = findViewById(R.id.editLogin1);
        pass = findViewById(R.id.editPass1);
        imie = findViewById(R.id.editImie);
        nazwisko = findViewById(R.id.editNazwisko);
        ulica = findViewById(R.id.editUlica);
        nrDom = findViewById(R.id.editNrDom);
        kod = findViewById(R.id.editKod);
        miasto = findViewById(R.id.editMiasto);
        panstwo = findViewById(R.id.editPanstwo);
    }

    public User GetData() {
        User user = new User(login.toString(), pass.toString(), imie.toString(), nazwisko.toString(),
                ulica.toString(), nrDom.toString(), kod.toString(),
                miasto.toString(), panstwo.toString());

        return user;
    }


    public void SendData(View view) {
        final String url = MYURL +"/user";
        User user = GetData();

        String userJson = Utils.parseToJson(user);
        Service service = new Service(getApplicationContext());
        service.postRejestracja(userJson);

        Intent menu = new Intent(this, MenuActivity.class);
        startActivity(menu);
    }
}
