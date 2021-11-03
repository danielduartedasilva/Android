package com.daniel.aula09.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.aula09.R;

public class CelularViewHolder extends RecyclerView.ViewHolder {

    TextView tvMarcaModelo;
    Button bDetalhes;

    public CelularViewHolder(@NonNull View itemView) {
        super(itemView);

        tvMarcaModelo = itemView.findViewById(R.id.tvMarcaModelo);
        bDetalhes     = itemView.findViewById(R.id.bDetalhes);

    }
}
