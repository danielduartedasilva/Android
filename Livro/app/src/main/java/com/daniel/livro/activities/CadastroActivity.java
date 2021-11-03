package com.daniel.livro.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daniel.livro.R;
import com.daniel.livro.controller.LivroDAO;
import com.daniel.livro.model.Livro;

public class CadastroActivity extends AppCompatActivity {
    EditText etTitulo;
    EditText etAutor;
    EditText etEditora;
    EditText etAno;
    Button bSalvar;
    
    LivroDAO livroDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        etTitulo  = findViewById(R.id.etTitulo);
        etAutor   = findViewById(R.id.etAutor);
        etEditora = findViewById(R.id.etEditora);
        etAno     = findViewById(R.id.etAno);
        bSalvar   = findViewById(R.id.bSalvar);
        
        livroDAO = new LivroDAO();
        
        bSalvar.setOnClickListener(v -> {
            if (etTitulo.getText().toString().isEmpty() || etAutor.getText().toString().isEmpty() || etEditora.getText().toString().isEmpty() || etAno.getText().toString().isEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }else {
                Livro livro = new Livro(
                        etTitulo.getText().toString(),
                        etAutor.getText().toString(),
                        etEditora.getText().toString(),
                        Integer.parseInt(etAno.getText().toString())
                
                );
                livroDAO.addLivro(livro);
                Toast.makeText(this, "Livro cadastrado com sucesso!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        
    }
}