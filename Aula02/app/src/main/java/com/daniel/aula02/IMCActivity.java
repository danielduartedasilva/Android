package com.daniel.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IMCActivity extends AppCompatActivity {
    EditText etPeso;
    EditText etAltura;
    Button bCalcIMC;
    TextView tvIMC;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        inicializarComponentes();

        bCalcIMC.setOnClickListener(v -> {
            if (etPeso.getText().toString().isEmpty() || etAltura.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha peso e altura para efetuar o cálculo !!", Toast.LENGTH_LONG).show();
            } else {
                float peso = Float.parseFloat(etPeso.getText().toString());
                float altura = Float.parseFloat(etAltura.getText().toString());
                float imc = peso / (altura * altura);
                String status;
                if (imc < 18.5f) {
                    status = "Abaixo do peso";
                } else if (imc < 25) {
                    status = "Peso normal";
                } else if (imc < 30) {
                    status = "Sobrepeso";
                } else if (imc < 35) {
                    status = "Obesidade Grau 1";
                } else if (imc < 40) {
                    status = "Obesidade Grau 2";
                } else {
                    status = "Obesidade mórbida";
                }
                String res = String.format("%.1f", imc);//converter o valor float do imc em uma string com apenas uma casa decimal
                tvIMC.setText(res);
                tvStatus.setText(status);
                //limpar os Edit Texts
                etPeso.getText().clear();
                etAltura.getText().clear();
            }
        });

    }
    private void  inicializarComponentes(){
        etPeso = findViewById(R.id.etPeso);// classe R do Android que gerencia tudo que tem na classe Res, id é a subclasse da classe R, gerencia os ids, o ponto são os atributos
        etAltura = findViewById(R.id.etAltura);// estabelecendo relação entre o código java e o xml
        bCalcIMC = findViewById(R.id.bCalcIMC);
        tvIMC = findViewById(R.id.tvIMC);
        tvStatus = findViewById(R.id.tvStatus);
    }
}