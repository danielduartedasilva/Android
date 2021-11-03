package com.daniel.aula11.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.aula11.FormActivity;
import com.daniel.aula11.R;
import com.daniel.aula11.database.AgendaDB;
import com.daniel.aula11.database.dao.ContatoDAO;
import com.daniel.aula11.entity.Contato;

import java.util.List;

public class ContatoAdapter extends RecyclerView.Adapter { // -------------------------------------------- ContatoAdapter é responsável por popular a RecyclerView, quem vai ser o layout da RecyclerView, qual o arquivo xml que será inserido dentro da RecyclerView e ao mesmo tempo será responsável por fazer o Bind, atualização dos dados da RecyclerView
    private Context context;
    private ContatoDAO dao;
    private List<Contato> agenda;

    public ContatoAdapter(Context context) {
        this.context = context;
        dao = AgendaDB.getInstance(context).getContatoDAO();
        agenda = dao.getContatos();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.contato_layout, parent, false);
        ContatoViewHolder contatoVH = new ContatoViewHolder(itemView);
        return contatoVH;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ContatoViewHolder contatoVH = (ContatoViewHolder) holder;
        Contato contato = agenda.get(position);
        contatoVH.tvNomeFone.setText(contato.toString());
        // ação de click longo do TextView
        contatoVH.tvNomeFone.setOnLongClickListener(view -> {
            Intent editarIntent = new Intent(context, FormActivity.class);
            // setar como "extra" o objeto "contato" que está sendo exibido na celula do click
            editarIntent.putExtra("contato", contato);
            context.startActivity(editarIntent);

            return false;
        });
    }

    @Override
    public int getItemCount() {
        return agenda.size(); // retorna a quantidade de contatos dentro da agenda
    }

    public void atualizarDataSet(){
        agenda.clear();
        agenda = dao.getContatos();
        notifyDataSetChanged();
    }
}
