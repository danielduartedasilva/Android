package com.daniel.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bCadastrarFuncionario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Main Activity criada!", Toast.LENGTH_SHORT).show();

        //Referenciando elementos de interface
        bCadastrarFuncionario = findViewById(R.id.bCadastrarFuncionario);

        //Ação de clique do botão
        bCadastrarFuncionario.setOnClickListener(v -> {
            Intent intent = new Intent(this, CadastrarFuncionarioActivity.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Main Activity iniciada!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Main Activity está rodando", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Main Activity pausada", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Main Activity parou", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Main Activity reiniciou", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Main Activity destruída", Toast.LENGTH_SHORT).show();
    }
}