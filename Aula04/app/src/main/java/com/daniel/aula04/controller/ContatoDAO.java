package com.daniel.aula04.controller;

import com.daniel.aula04.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {//Data Aces Objet, responsavel por todas as ações dentro de uma tabela no banco de dados, inserir, atualizar, buscar, excluir ...
    private static List<Contato> agenda = new ArrayList<>();
    public void salvar(Contato contato) {//----------------------------recebe o objeto do tipo contato
        agenda.add(contato);//-----------------------------------------salvando na lista
    }
    public void excluir(int position){
        agenda.remove(position);
    }
    public Contato getContato(int position){
        return agenda.get(position);
    }
    public List<Contato> getAgenda(){// retorna a lista toda
        return  agenda;
    }
}
