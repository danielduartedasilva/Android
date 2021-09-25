package com.daniel.atividade01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.daniel.atividade01.controller.FuncionarioDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView lvFuncionarios;
    FloatingActionButton fabNovo;
    FuncionarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//o onCreate só é chamado uma vez quando a activity é criada
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFuncionarios = findViewById(R.id.lvFuncionarios);
        fabNovo        = findViewById(R.id.fabNovo);
        dao = new FuncionarioDAO();

        // ação de clique do botão
        fabNovo.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));//preciso de uma Intent para informar de qual Activity estou e para onde vou
        });
        // ação de clique dos elementos da lista
        lvFuncionarios.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, DetalhesActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {// o onResume é sempre chamado, nesse caso será utilizado para atualizar os elementos da lista
        super.onResume();
        lvFuncionarios.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.getFolhaPagamento()));// setAdapter serve para adaptar os dados que inserimos nessa lista. simple_list_item_1 = formado mais basico de lista. dao.getFolhaPagamento = retorna todos os funcionários dentro da folha de pagamento
    }
}