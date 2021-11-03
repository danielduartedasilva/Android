package com.daniel.aula11.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.aula11.R;

public class ContatoViewHolder extends RecyclerView.ViewHolder { // ViewHolder é uma classe de apoio da RecyclerView, serve para fazer com que cada elemento da lista da RecyclerView, converse com o layout contato_layout
    TextView tvNomeFone;
    public ContatoViewHolder(@NonNull View itemView) {
        super(itemView);
        tvNomeFone = itemView.findViewById(R.id.tvNomeFone);
    }
}
