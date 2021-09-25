package com.daniel.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarFuncionarioActivity extends AppCompatActivity {

    EditText etNome;
    EditText etHorasTrabalhadas;
    EditText etValorHora;
    Button bCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_funcionario);
        //Toast.makeText(this, "Activity Cadastrar Funcionario foi criada!", Toast.LENGTH_SHORT).show();

        inicializarComponentes();
        bCadastrar.setOnClickListener(v -> {
            if (etNome.getText().toString().isEmpty() || etHorasTrabalhadas.getText().toString().isEmpty() || etValorHora.getText().toString().isEmpty()){
                Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_LONG).show();
            }else{
                String nome = etNome.getText().toString();
                int horasTrabalhadas = Integer.parseInt(etHorasTrabalhadas.getText().toString());
                float valorHora = Float.parseFloat(etValorHora.getText().toString());
                //aqui vai os cálculos continuar na aula 02 02:04:00
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

                Bundle bundle = new Bundle();
                bundle.putString("nome", nome);//putString seria o "nome" rótulo na caixa, nome é o que está dentro da caixa
                bundle.putInt("horasTrabalhadas", horasTrabalhadas);
                bundle.putFloat("valorHora", valorHora);
                bundle.putFloat("salarioBruto", salarioBruto);
                bundle.putFloat("ir", ir);
                bundle.putFloat("inss", inss);
                bundle.putFloat("fgts", fgts);
                bundle.putFloat("salarioLiquido", salarioLiquido);

                Intent intent = new Intent(this, DetalhesActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    private void inicializarComponentes(){
        etNome             = findViewById(R.id.etNome);
        etHorasTrabalhadas = findViewById(R.id.etHorasTrabalhadas);
        etValorHora        = findViewById(R.id.etValorHora);
        bCadastrar         = findViewById(R.id.bCadastrar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        etNome.getText().clear();
        etHorasTrabalhadas.getText().clear();
        etValorHora.getText().clear();
    }
}