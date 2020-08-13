package app.loginhardcode.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import app.loginhardcode.R;

public class VerificaLogin extends AppCompatActivity implements View.OnClickListener{

    private TextView mensagemTextView;
    private Integer usuario, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_verifica_login);

        mensagemTextView = findViewById(R.id.textview_mensagem);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getArguments();
        checkLogin();
    }

    @Override
    public void onClick(View view) {

    }

    private void getArguments(){

        Intent intent = getIntent();

        // Pega as informações que foram enviadas da tela principal
        Bundle embrulho = intent.getExtras();

        if(embrulho != null){
            usuario = embrulho.getInt(MainActivity.KEY_USUARIO);
            senha   = embrulho.getInt(MainActivity.KEY_SENHA);
        }
    }

    private void checkLogin(){

        if (usuario == 3000397 && senha == 7930003){
            mensagemTextView.setText("Bem vindo " + usuario);
        }
        else{
            mensagemTextView.setText("Erro no login");
        }
    }

    // Responsável em adicionar a função de voltar a tela
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {

        Bundle argumento = new Bundle();

        argumento.putSerializable(MainActivity.KEY_USUARIO, usuario);
        argumento.putSerializable(MainActivity.KEY_SENHA, senha);

        Intent intent = new Intent();

        intent.putExtras(argumento);

        setResult(RESULT_OK, intent);

        Log.d(MainActivity.TAG, "Destruindo - ResultCode : " + RESULT_OK);

        super.finish();
    }
}