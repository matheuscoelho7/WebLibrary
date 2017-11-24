package com.example.matheussilva.weblibrary.Views;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matheussilva.weblibrary.Fachada.Fachada;
import com.example.matheussilva.weblibrary.R;

public class LoginActivity extends AppCompatActivity {


    Button btnAcessar;
    EditText edtLogin, edtSenha;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button buttonAcessar = (Button) findViewById(R.id.btnAcessar);

        fachada = Fachada.getInstance(this);

        usuario = fachada.usuarioLogado();

        if (usuario.getId() > 0) {
            verificarTipoUsuario(usuario.getTipo());
        }
    }

    public void entrar(View v) {

        email = (EditText) findViewById(R.id.editText_email_login);
        senha = (EditText) findViewById(R.id.editText_senha_login);

        try {
            usuario = fachada.usuarioLogar(email.getText().toString(), senha.getText().toString());

            if (usuario.getId() > 0) {
                verificarTipoUsuario(usuario.getTipo());
            } else {
                Toast.makeText(getApplicationContext(), "Dados inválidos, tente novamente!", Toast.LENGTH_LONG).show();
            }
        } catch (NegocioException e) {
            Toast.makeText(getApplicationContext(), e.getMessage.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void verificarTipoUsuario(String tipo){

        Toast.makeText(getApplicationContext(), "Redirecionando, aguarde...!", Toast.LENGTH_LONG).show();
        Intent itEntrar;

        if (tipo.equals("Prestador")) {
            itEntrar = new Intent(TelaLogin.this, StartPrestador.class);
        }else{
            itEntrar = new Intent(TelaLogin.this, StartCliente.class);
        }

        itEntrar.putExtra("usuario", usuario);
        startActivity(itEntrar);
    }

    public void cadastrar(View v) {
        Intent i = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(i);
    }
}
