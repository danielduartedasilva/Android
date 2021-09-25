package com.daniel.aula05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daniel.aula05.controller.ProdutoDAO;
import com.daniel.aula05.model.Produto;

public class CadastroActivity extends AppCompatActivity {
    EditText etNome;
    EditText etQuantidade;
    Button bSalvar;
    ProdutoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        etNome = findViewById(R.id.etNome);
        etQuantidade = findViewById(R.id.etQuantidade);
        bSalvar      = findViewById(R.id.bSalvar);
        dao = new ProdutoDAO();

        bSalvar.setOnClickListener(v -> {
            if (etNome.getText().toString().isEmpty() || etQuantidade.getText().toString().isEmpty()){
                Toast.makeText(this, "Prencha todos dos campos", Toast.LENGTH_SHORT).show();
            }else{
                //aqui pode estar a dúvida do exercício, folha de pagamento
                Produto produto = new Produto(
                     etNome.getText().toString(),
                     Integer.parseInt(etQuantidade.getText().toString())
                );
                dao.addProduto(produto);
                Toast.makeText(this, "Produto cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                finish();//mata a activity atual e retorna para a anterior
            }
        });
    }

}