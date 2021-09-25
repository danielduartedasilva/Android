package com.daniel.atividade01.controller;

import com.daniel.atividade01.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private static List<Funcionario> folhaPagamento = new ArrayList<>();

    public void salvar(Funcionario funcionario){
        folhaPagamento.add(funcionario);
    }

    public void excluir(int position){
        folhaPagamento.remove(position);
    }

    public Funcionario getFuncionario(int position){
        return folhaPagamento.get(position);
    }

    public List<Funcionario> getFolhaPagamento(){
        return folhaPagamento;
    }

}
