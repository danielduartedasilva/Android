package com.daniel.atividade01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daniel.atividade01.controller.FuncionarioDAO;
import com.daniel.atividade01.model.Funcionario;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome;
    EditText etHorasTrabalhadas;
    EditText etValorHora;
    Button bSalvar;
    FuncionarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        etNome             = findViewById(R.id.etNome);
        etHorasTrabalhadas = findViewById(R.id.etHorasTrabalhadas);
        etValorHora        = findViewById(R.id.etValorHora);
        bSalvar            = findViewById(R.id.bSalvar);
        dao = new FuncionarioDAO();

        bSalvar.setOnClickListener(v -> {
            if (etNome.getText().toString().isEmpty() || etHorasTrabalhadas.getText().toString().isEmpty() || etValorHora.getText().toString().isEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }else{
                Funcionario funcionario = new Funcionario();
                //-----------------------------------uma dica é usar aqui parte do código da atividade1
                String nome = etNome.getText().toString();
                int horasTrabalhadas = Integer.parseInt(etHorasTrabalhadas.getText().toString());
                float valorHora = Float.parseFloat(etValorHora.getText().toString());

                float salarioBruto = horasTrabalhadas * valorHora;
                float ir;
                if (salarioBruto < 1372.82f){
                    ir = 0;
                }else if (salarioBruto < 2743.26f){
                    ir = (salarioBruto * 15)/100;
                }else{
                    ir = (salarioBruto * 27.5f)/100;
                }
                float inss;
                if (salarioBruto < 868.30){
                    inss = (salarioBruto * 8)/100;
                }else if (salarioBruto < 1447.15f) {
                    inss = (salarioBruto * 9) / 100;
                }else if (salarioBruto < 2894.29f) {
                    inss = (salarioBruto * 11) / 100;
                }else{
                    inss = 318.37f;
                }
                float fgts = (salarioBruto * 8)/100;
                float salarioLiquido = salarioBruto - ir - inss;
                //String res = String.format("%.2f", ir);
                //----------------------------------
                dao.salvar(funcionario);
                Toast.makeText(this, "Funcionario salvo com sucesso", Toast.LENGTH_SHORT).show();
                finish();//encerra a activity atual e volta para a activity anterior
            }

        });
    }
}