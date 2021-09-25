package com.daniel.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.daniel.aula04.controller.ContatoDAO;
import com.daniel.aula04.model.Contato;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvNome;
    TextView tvTelefone;
    TextView tvEmail;
    ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        //2 referenciando os elementos de interface (vim do MainActivity)
        tvNome     = findViewById(R.id.tvNome);
        tvTelefone = findViewById(R.id.tvTelefone);
        tvEmail    = findViewById(R.id.tvEmail);

        //3 criando uma nova instancia do DAO
        dao = new ContatoDAO();

        //4 recebemos a intent
        Intent intent = getIntent();

        //5 pegamos a variável posição, ega o extra position, se o valor for inválido será tratado como -1
        int position = intent.getIntExtra("position", -1);//---------------dafaultValue -1 garante que não haverá valor negativo

        //6 se o valor for -1 a gente finaliza a actiity
        if (position == -1){ finish();}

        //7 senão criamos um objeto contato, acessamos nossa dao, buscamos um contato específico baseado na posição que a gente recebeu
        Contato contato = dao.getContato(position);//----------------------------------contato específico do arraylist que estaja na opção posição procurada

        //8 usamos os dados desse contato para alimentar os nossos TextView
        tvNome.setText(contato.getNome());
        tvTelefone.setText(contato.getTelefone());
        tvEmail.setText(contato.getEmail());
    }
    }