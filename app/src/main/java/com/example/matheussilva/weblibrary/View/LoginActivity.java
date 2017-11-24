package com.example.matheussilva.weblibrary.View;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matheussilva.weblibrary.ClassesBasicas.Usuario;
import com.example.matheussilva.weblibrary.Fachada.Fachada;
import com.example.matheussilva.weblibrary.R;
import com.example.matheussilva.weblibrary.Util.NegocioException;

public class LoginActivity extends AppCompatActivity {
    Button btnAcessar;
    EditText edtLogin, edtSenha;
    Usuario usuario;
    Fachada fachada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnAcessar = (Button)findViewById(R.id.btnAcessar);
        edtLogin = (EditText)findViewById(R.id.edtLogin);
        edtSenha = (EditText)findViewById(R.id.edtPassword);
    }

    EditText email, senha;

    private SQLiteOpenHelper mDBHelper;

        Fachada f = new Fachada();
            f.getInstance(this);
        usuario = fachada.usuarioLogado();

        if (usuario.getId() > 0) {
            verificarTipoUsuario(usuario.getTipo());
        }

    public void entrar(View v) {

        email = (EditText) findViewById(R.id.edtLogin);
        senha = (EditText) findViewById(R.id.edtPassword);

        try {
            usuario = fachada.usuarioLogar(email.getText().toString(), senha.getText().toString());

            if (usuario.getId() > 0) {
                verificarTipoUsuario(usuario.getTipo());
            } else {
                Toast.makeText(getApplicationContext(), "Dados inválidos, tente novamente!", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void verificarTipoUsuario(String tipo){

        Intent intent;

        Toast.makeText(getApplicationContext(), "Redirecionando, aguarde...!", Toast.LENGTH_LONG).show();
        Intent itEntrar;

        //Tipo do login
        if (tipo.equals("Padrao")) {
             intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        }else{
             intent = new Intent(getApplication(), LoginActivity.class);
            startActivity(intent);
        }

        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }

    public void cadastrar(View v) {
        Intent i = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(i);
    }
}
