package com.daniel.atividadecarros;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daniel.atividadecarros.controller.CarroDAO;
import com.daniel.atividadecarros.model.Carro;

public class DetalhesActivity extends AppCompatActivity {
    TextView tvMarca;
    TextView tvModelo;
    TextView tvCor;
    TextView tvCombustivel;
    TextView tvAno;
    TextView tvMotor;
    TextView tvValor;
    Button bExcluir;
    CarroDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        tvMarca       = findViewById(R.id.tvMarca);
        tvModelo      = findViewById(R.id.tvModelo);
        tvCor         = findViewById(R.id.tvCor);
        tvCombustivel = findViewById(R.id.tvCombustivel);
        tvAno         = findViewById(R.id.tvAno);
        tvMotor       = findViewById(R.id.tvMotor);
        tvValor       = findViewById(R.id.tvValor);
        bExcluir      = findViewById(R.id.bExcluir);

        dao = new CarroDAO();
        Intent intent = getIntent(); //recebe os dados da intent da Activity que disparou a DetalhesActivity
        int i = intent.getIntExtra("i", -1);
        // caso o valor de i seja -1, significa que uma activit não autorizada disparou essa DetalhesActivity
        if(i == -1){
            finish();// volta para a Activity anterior
        }
        // buscar no arraylist o jogo salvo na posição indicada pela variável i
        Carro c = dao.getCarro(i);
        // setar o texto das text views com os valores do objeto c
        tvMarca.setText(c.getMarca());
        tvModelo.setText(c.getModelo());
        tvCor.setText(c.getCor());
        tvCombustivel.setText(c.getCombustivel());
        tvAno.setText("Ano do carro: " + c.getAno());
        tvMotor.setText("Motor: " + c.getMotor());
        tvValor.setText("Valor do carro: " + c.getValor());

        //ação de clique do botão excluir
        bExcluir.setOnClickListener(v -> {
            // alerta perguntando se deseja excluir o carro
            new AlertDialog.Builder(this)
                    .setTitle("Excluir carro")
                    .setMessage("Tem certeza que deseja excluir este jogo\n" + "Esta ação não pode ser desfeita!")
                    .setPositiveButton("Sim", (dialogInterface, i1) -> {
                        dao.excluirCarro(i);
                        Toast.makeText(this, "Carro excluído com sucesso", Toast.LENGTH_SHORT).show();
                        finish();// mata a activity atual e volta para a anterior
                    })
                    .setNegativeButton("Não", null)
                    .show();
        });
    }
}