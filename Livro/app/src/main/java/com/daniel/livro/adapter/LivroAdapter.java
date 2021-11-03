package com.daniel.livro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.livro.R;
import com.daniel.livro.controller.LivroDAO;
import com.daniel.livro.model.Livro;

import java.util.List;

public class LivroAdapter extends RecyclerView.Adapter {

    private Context context;
    private LivroDAO livroDAO;

    public LivroAdapter(Context context, LivroDAO livroDAO) {
        this.context = context;
        this.livroDAO = livroDAO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLivro = LayoutInflater.from(context).inflate(R.layout.layout_livro, parent, false);
        LivroViewHolder livroViewHolder = new LivroViewHolder(viewLivro);
        return livroViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LivroViewHolder livroViewHolder = (LivroViewHolder) holder;
        Livro l = livroDAO.getLivro(position);
        livroViewHolder.tvTitulo.setText("Titulo: " + l.getTitulo());
        livroViewHolder.tvAutor.setText("Autor: " + l.getAutor());
        livroViewHolder.tvEditora.setText("Editora: " + l.getEditora());
        livroViewHolder.tvAno.setText("Ano: " + l.getAno());
    }

    @Override
    public int getItemCount() {
        return livroDAO.getListaLivros().size();
    }
}
