package com.daniel.atividade01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.daniel.atividade01.controller.FuncionarioDAO;
import com.daniel.atividade01.model.Funcionario;

public class DetalhesActivity extends AppCompatActivity {
    TextView tvNome;
    TextView tvSalarioBruto;
    FuncionarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        tvNome         = findViewById(R.id.tvNome);
        tvSalarioBruto =  findViewById(R.id.tvSalarioBruto);
        dao = new FuncionarioDAO();

        Intent intent = getIntent();//---------------------------------------------------------------- recebe os dados da intent da Activity que disparou a Detalhes Activity
        int position = intent.getIntExtra("position", -1);// caso o valor de 'position' seja -1, significa que uma activity não autorizada disparou a DetalhesActivity

        if (position == -1){
            finish();//-------------------------------------------------------------------------------volta para a Activity anterior
        }
        Funcionario funcionario = dao.getFuncionario(position);//--------------------------------------para buscar um funcionario específico no arrey que esteja na posição desejada

        // setar o texto das text views com os valores do objeto 'funcionario'
        tvNome.setText(funcionario.getNome());
        tvSalarioBruto.setText("Salario Bruto: " + funcionario.getSalarioBruto());
        //tvSalarioBruto.setText(String.valueOf(funcionario.getFloat("salarioBruto")));

    }
}