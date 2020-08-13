package app.loginhardcode.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.loginhardcode.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int CHECAR_LOGIN_CODE = 99;
    public static final String KEY_USUARIO    = "usuario";
    public static final String KEY_SENHA      = "senha";
    public static final String TAG            = MainActivity.class.getSimpleName();

    private EditText usuarioEditText;
    private EditText senhaEditText;
    private Button   loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Pegando os valores dos elementos de layout
        usuarioEditText = findViewById(R.id.edittext_usuario);
        senhaEditText   = findViewById(R.id.edittext_senha);
        loginButton     = findViewById(R.id.button_login);

        // Definindo o OnClickListern do botão
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == loginButton){
            verificaDados();
        }
    }

    private void verificaDados(){

        Integer usuario, senha;

        try{
            usuario = Integer.valueOf(usuarioEditText.getText().toString());
            senha   = Integer.valueOf(senhaEditText.getText().toString());
        }catch (NumberFormatException nfe){
            usuario = null;
            senha   = null;
        }

        if (usuario != null && senha != null){

            // Cria um Bundle com os argumentos necessários na outra activity
            Bundle args = new Bundle();

            // Dados inseridos no bundle (chave, valor)
            args.putInt(KEY_USUARIO, usuario);
            args.putInt(KEY_SENHA, senha);

            // Cria a intenção de abrir uma nova tela
            Intent intent = new Intent(this, VerificaLogin.class);

            //Inclui os argumentos na intenção
            intent.putExtras(args);

            //Solicita a abertura da nova activity
            //Contudo essa activity receberá informação como resultado
            startActivityForResult(intent, CHECAR_LOGIN_CODE);
        }
        else{
            Toast.makeText(this, "Os campos usuário e senha devem ser preenchidos!", Toast.LENGTH_SHORT).show();
        }
    }
}