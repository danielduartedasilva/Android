package com.daniel.atividadecarros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.daniel.atividadecarros.controller.CarroDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    ListView lvCarros;
    FloatingActionButton fabAdd;
    CarroDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCarros = findViewById(R.id.lvCarros);
        fabAdd   = findViewById(R.id.fabAdd);
        dao = new CarroDAO();

        fabAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });
            //ação de clique rápido em elementos da lista
        lvCarros.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent detalhesIntent = new Intent(this, DetalhesActivity.class);
            detalhesIntent.putExtra("i", i); // posição do elemento atual da lista
            startActivity(detalhesIntent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        lvCarros.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getListaCarros()
        ));
    }
}