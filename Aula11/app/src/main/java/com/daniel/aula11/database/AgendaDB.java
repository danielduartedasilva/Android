package com.daniel.aula11.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.daniel.aula11.database.dao.ContatoDAO;
import com.daniel.aula11.entity.Contato;

@Database(entities = {Contato.class}, version = 1, exportSchema = false) // -------------------------------- exportSchema = false o room ele exporta os arquivos do json, como eu não quero uso esse argumento
public abstract class AgendaDB extends RoomDatabase {

    public static final String DB_NAME = "agenda"; // ----------------------------------------------------- nome do banco de dados não será alterado nunca
    public abstract ContatoDAO getContatoDAO(); // --------------------------------------------------------- retorna uma instancia de contatoDAO
    private static AgendaDB instance; // ------------------------------------------------------------------ instancia única do banco de dados desta classe
    public static AgendaDB getInstance(Context context) { // -----------------------------------------------como a classe é abstrata eu tenho que usar o static
        // verificar se a instância é nula
        if (instance == null){
            // criar uma nova instancia do banco de dados
            instance = Room.databaseBuilder(context, AgendaDB.class, DB_NAME).allowMainThreadQueries().build();
        }
        // retorna de instância ativa deste bd
        return instance;
    }

}
