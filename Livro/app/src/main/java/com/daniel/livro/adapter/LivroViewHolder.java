package com.daniel.livro.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.livro.R;

public class LivroViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitulo;
    TextView tvAutor;
    TextView tvEditora;
    TextView tvAno;

    public LivroViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitulo  = itemView.findViewById(R.id.tvTitulo);
        tvAutor   = itemView.findViewById(R.id.tvAutor);
        tvEditora = itemView.findViewById(R.id.tvEditora);
        tvAno     = itemView.findViewById(R.id.tvAno);

    }
}
