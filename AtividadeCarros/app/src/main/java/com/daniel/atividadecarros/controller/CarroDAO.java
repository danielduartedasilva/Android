package com.daniel.atividadecarros.controller;

import com.daniel.atividadecarros.model.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    private static List<Carro> listacarros = new ArrayList<>();
    public void addCarro(Carro c){
        listacarros.add(c);
    }
    public void excluirCarro(int i){
        listacarros.remove(i);
    }
    public Carro getCarro(int i){
        return listacarros.get(i);
    }
    public List<Carro> getListaCarros(){
        return listacarros;
    }
}
