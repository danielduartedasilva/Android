package com.daniel.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bActivity2;
    Button bAbrirCadastro;
    Button bIMC;
    Button bConverterTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Main Activity criada", Toast.LENGTH_SHORT).show();

        //Referenciando elementos de interface
        bActivity2     = findViewById(R.id.bActivity2);
        bAbrirCadastro = findViewById(R.id.bAbrirCadastro);
        bIMC           = findViewById(R.id.bIMC);
        bConverterTemp = findViewById(R.id.bConverterTemp);

        //Ação de click dos botões
        bActivity2.setOnClickListener(v -> {
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        });
        bAbrirCadastro.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });
        bIMC.setOnClickListener(v -> {
            startActivity(new Intent(this, IMCActivity.class));
        });
        bConverterTemp.setOnClickListener(v -> {
            startActivity(new Intent(this, TemperaturasActivity.class));
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Main Activity iniciada", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Main Activity está rodando", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Main Activity está pausada", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Main Activity está parada", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Main Activity reiniciada", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Main Activity destruída", Toast.LENGTH_SHORT).show();
    }
}