package com.daniel.atividadecarros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daniel.atividadecarros.controller.CarroDAO;
import com.daniel.atividadecarros.model.Carro;

public class CadastroActivity extends AppCompatActivity {
    EditText etMarca;
    EditText etModelo;
    EditText etCor;
    EditText etCombustivel;
    EditText etAno;
    EditText etMotor;
    EditText etValor;
    Button bSalvar;
    CarroDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        etMarca = findViewById(R.id.etMarca);
        etModelo = findViewById(R.id.etModelo);
        etCor =  findViewById(R.id.etCor);
        etCombustivel = findViewById(R.id.etCombustivel);
        etAno = findViewById(R.id.etAno);
        etMotor = findViewById(R.id.etMotor);
        etValor = findViewById(R.id.etValor);
        bSalvar = findViewById(R.id.bSalvar);

        dao = new CarroDAO();
        bSalvar.setOnClickListener(v -> {
            if(salvar()) {
                finish(); // mata a activity e volta para a anterior
            }
        });
    }
    private boolean salvar(){

        if(etMarca.getText().toString().isEmpty() ||
                etModelo.getText().toString().isEmpty() ||
                etCor.getText().toString().isEmpty() ||
                etCombustivel.getText().toString().isEmpty() ||
                etAno.getText().toString().isEmpty() ||
                etMotor.getText().toString().isEmpty() ||
                etValor.getText().toString().isEmpty()){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return false;
        }

        Carro c = new Carro(
                etMarca.getText().toString(),
                etModelo.getText().toString(),
                etCor.getText().toString(),
                etCombustivel.getText().toString(),
                Integer.parseInt(etAno.getText().toString()),
                Float.parseFloat(etMotor.getText().toString()),
                Float.parseFloat(etValor.getText().toString())

        );
        dao.addCarro(c);
        Toast.makeText(this, "Carro cadastrado à lista!", Toast.LENGTH_SHORT).show();

        return true;
    }
}