package com.daniel.aula05b;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daniel.aula05b.model.Jogo;
import com.daniel.aula05b.model.controller.JogoDAO;

public class DetalhesActivity extends AppCompatActivity {
    TextView tvtitulo;
    TextView tvGenero;
    TextView tvAno;
    Button bExcluir;
    JogoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        tvtitulo = findViewById(R.id.tvTitulo);
        tvGenero = findViewById(R.id.tvGenero);
        tvAno = findViewById(R.id.tvAno);
        bExcluir = findViewById(R.id.bExcluir);
        dao = new JogoDAO();

        Intent intent = getIntent();//------------------------------------------------------ receber os dados da intent da activity que disparou a DetalhesActivity
        int i = intent.getIntExtra("i", -1);

        //caso o valor de i seja -1 significa que uma ativitivy não autorizada dispoarou a detalhes activity
        if (i == -1) {
            finish();// ----------------------------------------------------------------------volta para a ativity anterior
        }
            // buscar no array list o jogo salvo na posição indicada pela variável i
            Jogo j = dao.getJogo(i);
            // setar o texto das text views com os valores do objeto j
            tvtitulo.setText(j.getTitulo());
            tvGenero.setText(j.getGenero());
            tvAno.setText("Ano de lançamento: " + j.getAno());

            // ação de clique do botão excluir
            bExcluir.setOnClickListener(v -> {
                // alerta perguntando se deseja realmente excluir o jogo
                new AlertDialog.Builder(this)
                        .setTitle("Excluir jogo")
                        .setMessage("Tem certeza que deseja excluir este jogo ?/n" +
                                "Esta ação não pode ser desfeita!")
                        .setPositiveButton("Sim", (dialogInterface, i1) -> {
                            dao.exluirJogo(i);
                            Toast.makeText(this, "Jogo excluído com sucesso !", Toast.LENGTH_SHORT).show();
                            finish();// --------------------------------------------------------------mata a activity atual e volta para a anterior
                        })
                        .setNegativeButton("Não, mudei de ideia", null)
                        .show();
            });
        }
    }