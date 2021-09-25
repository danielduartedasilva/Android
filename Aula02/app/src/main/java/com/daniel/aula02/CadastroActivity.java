package com.daniel.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome;
    EditText etIdade;
    EditText etEmail;
    EditText etTelefone;
    Button bCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializarComponentes();
        bCadastrar.setOnClickListener(v -> {
            if (etNome.getText().toString().isEmpty() || etIdade.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty() || etTelefone.getText().toString().isEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }else{
                String nome = etNome.getText().toString();
                int idade = Integer.parseInt(etIdade.getText().toString());
                String email = etEmail.getText().toString();
                String telefone = etTelefone.getText().toString();
                Bundle bundle = new Bundle(); // ------------------------------------------------------------------------o Intent é o caminhão de mudança de uma activity para outra e o Buncle são as caixas
                bundle.putString("nome", nome);
                bundle.putInt("idade", idade);
                bundle.putString("email", email);
                bundle.putString("telefone", telefone);
                Intent intent = new Intent(this, ResultadoActivity.class);// --------------------------------tela onde estou e para onde irei
                intent.putExtras(bundle);// ------------------------------------------------------------------------------carregando o caminhão com as caixas
                startActivity(intent);// ---------------------------------------------------------------------------------fazendo a mudança

            }
        });
    }
    private void inicializarComponentes() {
        etNome     = findViewById(R.id.etNome);
        etIdade    = findViewById(R.id.etIdade);
        etEmail    = findViewById(R.id.etEmail);
        etTelefone = findViewById(R.id.etTelefone);
        bCadastrar = findViewById(R.id.bCadastrar);

    }

    @Override
    protected void onStart() {
        super.onStart();
        etNome.getText().clear();
        etIdade.getText().clear();
        etEmail.getText().clear();
        etTelefone.getText().clear();
    }
}