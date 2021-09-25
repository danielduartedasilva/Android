package com.daniel.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daniel.aula04.controller.ContatoDAO;
import com.daniel.aula04.model.Contato;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome;
    EditText etTelefone;
    EditText etEmail;
    Button bSalvar;
    ContatoDAO dao;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        
        etNome     = findViewById(R.id.etNome);
        etTelefone = findViewById(R.id.etTelefone);
        etEmail    = findViewById(R.id.etEmail);
        bSalvar    = findViewById(R.id.bSalvar);
        dao = new ContatoDAO();
        
        bSalvar.setOnClickListener(v -> {
            if (etNome.getText().toString().isEmpty() || etTelefone.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty()){
                Toast.makeText(this, "Por favor prencha todos os campos", Toast.LENGTH_SHORT).show();
            }else {
                Contato contato = new Contato(//-------------------------------------construtor parametrizado
                        etNome.getText().toString(),
                        etTelefone.getText().toString(),
                        etEmail.getText().toString()
                );
                dao.salvar(contato);
                Toast.makeText(this, "Contato foi salvo com sucesso!", Toast.LENGTH_SHORT).show();
                finish();//----------------------------------------------------------------------"mata" a Activity atual e nos devolve a Activity anterior, encerra a Activity Restart, na outra Activity Start, Resume, na que matamos Stop e Destroy
            }
        });
        
    }
}