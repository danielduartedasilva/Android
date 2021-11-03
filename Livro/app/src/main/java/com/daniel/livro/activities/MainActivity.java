package com.daniel.livro.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.daniel.livro.R;
import com.daniel.livro.adapter.LivroAdapter;
import com.daniel.livro.controller.LivroDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvLivros;
    FloatingActionButton fabAdd;

    LivroDAO livroDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvLivros = findViewById(R.id.rvLivros);
        fabAdd   = findViewById(R.id.fabAdd);

        livroDAO = new LivroDAO();

        fabAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });
        RecyclerView.LayoutManager meuLayout = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );
        rvLivros.setLayoutManager(meuLayout);

    }

    @Override
    protected void onResume() {
        super.onResume();
        LivroAdapter meuAdapter = new LivroAdapter(this, livroDAO);
        rvLivros.setAdapter(meuAdapter);
    }
}