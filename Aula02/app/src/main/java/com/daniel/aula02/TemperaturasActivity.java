package com.daniel.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TemperaturasActivity extends AppCompatActivity {
    EditText etCelsius;
    Button bConverter;
    TextView tvK, tvF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperaturas);
        etCelsius = findViewById(R.id.etCelsius);
        bConverter = findViewById(R.id.bConverter);
        tvF = findViewById(R.id.tvF);
        tvK = findViewById(R.id.tvK);

        bConverter.setOnClickListener(v -> {
            if (etCelsius.getText().toString().isEmpty()){
                Toast.makeText(this, "Prencha a temperatura", Toast.LENGTH_LONG).show();
                float c = Float.parseFloat(etCelsius.getText().toString());
                float f = (c * (9/5)) + 32;
                float k = c + 273.15f;
                tvK.setText("K: " + k + "°");
                tvF.setText("F: " + f + "°");
                etCelsius.getText().clear();
            }
        });
    }
}