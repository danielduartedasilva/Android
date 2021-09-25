package com.daniel.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.daniel.aula04.controller.ContatoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    ListView lvContatos;
    FloatingActionButton fabNovo;
    ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvContatos = findViewById(R.id.lvContatos);
        fabNovo    = findViewById(R.id.fabNovo);
        dao = new ContatoDAO();

        //Ação de click do botão
        fabNovo.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });
        //ação de clique dos elementos da lista, 1 quanto clicar num elemento da lista, vou criar uma intent, pegando a posição desse elemento da lista, guardo dentro do intent como extra chamado position, utilizando o intent para iniciar a DetalhesActivity (continuação explicação agora na DetalhesActivity)
        lvContatos.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, DetalhesActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        });
        //ação de clique longo dos elementos da lista
        lvContatos.setOnItemLongClickListener((parent, view, position, id) -> {
            dao.excluir(position);
            Toast.makeText(this, "Contato excluído!", Toast.LENGTH_SHORT).show();
            onResume();
            return  false;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        lvContatos.setAdapter(new ArrayAdapter<>( //serve para adaptar os dados que estamos inserindo nessa list
                this,
                android.R.layout.simple_list_item_1,//------------------------------------formato mais básico de lista
                dao.getAgenda()//---------------------------------------------------------fonte de dados
        ));
    }
}