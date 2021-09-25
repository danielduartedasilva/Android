package com.daniel.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvNome;
    TextView tvSalarioBruto;
    TextView tvIr;
    TextView tvInss;
    TextView tvFgts;
    TextView tvSalarioLiquido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        inicializarComponentes();

        Intent intent = getIntent();//----------------------------recebemos a intent da CadastrarFuncionarioActivity
        Bundle bundle = intent.getExtras();

        if (bundle == null){// caso for nulo, alguma activity disporou erroneamente
            Toast.makeText(this, "Activity não iniciada corretamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        }

        tvNome.setText(bundle.getString("nome"));
        tvSalarioBruto.setText(String.valueOf(bundle.getFloat("salarioBruto")));
        tvIr.setText(String.valueOf(bundle.getFloat("ir")));
        tvInss.setText(String.valueOf(bundle.getFloat("inss")));
        tvFgts.setText(String.valueOf(bundle.getFloat("fgts")));
        tvSalarioLiquido.setText(String.valueOf(bundle.getFloat("salarioLiquido")));
    }

    private void inicializarComponentes(){
        tvNome           = findViewById(R.id.tvNome);
        tvSalarioBruto   = findViewById(R.id.tvSalarioBruto);
        tvIr             = findViewById(R.id.tvIr);
        tvInss           = findViewById(R.id.tvInss);
        tvFgts           = findViewById(R.id.tvFgts);
        tvSalarioLiquido = findViewById(R.id.tvSalarioLiquido);
    }
}