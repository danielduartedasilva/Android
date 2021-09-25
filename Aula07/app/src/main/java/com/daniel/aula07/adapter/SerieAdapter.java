package com.daniel.aula07.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.aula07.R;
import com.daniel.aula07.controller.SerieDAO;
import com.daniel.aula07.model.Serie;

public class SerieAdapter extends RecyclerView.Adapter {
    // 2 atributos funcamentais para um adapter
    private Context context; //----------------------------------------------------------------- qual activity que as ações ocorrerão
    private SerieDAO serieDAO; // objeto que acessa e manipula os dados da fonte de dados (Array List)

    // construtor adapter
    public SerieAdapter(Context context, SerieDAO serieDAO) {
        this.context = context;
        this.serieDAO = serieDAO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewSerie = LayoutInflater.from(context).inflate(R.layout.layout_serie, parent, false);
        // determinar qual viewHolder será utilizada por este adapter
        SerieViewHolder serieViewHolder = new SerieViewHolder(viewSerie);
        return serieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SerieViewHolder serieViewHolder = (SerieViewHolder) holder;
        Serie s = serieDAO.getSerie(position);
        serieViewHolder.tvTitulo.setText(s.getTitulo());
        serieViewHolder.tvGenero.setText("Gênero: " + s.getGenero());
        serieViewHolder.tvTemporadas.setText("N° de temporadas: " + s.getTemporadas());
        serieViewHolder.tvOndeAssistir.setText("Onde assistir: " + s.getOndeAssistir());
    }

    @Override
    public int getItemCount() {
        return serieDAO.getListaSeries().size();
    }
}
