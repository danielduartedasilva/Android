package com.daniel.aula07.controller;

import com.daniel.aula07.model.Serie;

import java.util.ArrayList;
import java.util.List;

public class SerieDAO {
    private static List<Serie> listaSeries = new ArrayList<>();
    public void addSerie(Serie s){
        listaSeries.add(s);
    }

    public Serie getSerie(int position){
        return listaSeries.get(position);
    }

    //o método acima é uma melhoria desse método
    //public Serie getSerie(String titulo){
        //for (Serie temp : listaSeries){
            //if (temp.getTitulo().equals(titulo)){
                //return temp;
            //}
        //}
        //return null;
    //}

    public List<Serie> getListaSeries(){
        return listaSeries;
    }
}
