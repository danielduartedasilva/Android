package com.daniel.livro.controller;

import com.daniel.livro.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private static List<Livro> listaLivros = new ArrayList<>();
    public void addLivro(Livro l){
        listaLivros.add(l);

    }
    public Livro getLivro(int position){
        return listaLivros.get(position);
    }
    public List<Livro> getListaLivros(){
        return listaLivros;
    }
}
