package com.daniel.aula09.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.aula09.DetalhesActivity;
import com.daniel.aula09.R;
import com.daniel.aula09.controller.CelularDAO;
import com.daniel.aula09.model.Celular;

public class CelularAdapter extends RecyclerView.Adapter {

    private Context context;
    private CelularDAO celularDAO;

    public CelularAdapter(Context context, CelularDAO celularDAO) {
        this.context = context;
        this.celularDAO = celularDAO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCelular = LayoutInflater.from(context).inflate(R.layout.celular_layout, parent, false);
        // determinar qual viewHolder será utilizado por este adapter para gerenciar os elementos de cada célula
        CelularViewHolder celViewHolder = new CelularViewHolder(viewCelular);
        return celViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CelularViewHolder celViewHolder = (CelularViewHolder) holder;
        Celular cel = celularDAO.getCelular(position);
        celViewHolder.tvMarcaModelo.setText(cel.getMarca() + " " + cel.getModelo());
        // ação de clique do botão
        celViewHolder.bDetalhes.setOnClickListener(v ->{
            Intent detalhesIntent = new Intent(context, DetalhesActivity.class);
            detalhesIntent.putExtra("position", position);
            context.startActivity(detalhesIntent);
        });
    }

    @Override
    public int getItemCount() {
        return celularDAO.getListaCel().size();
    }
}
