package com.daniel.aula11.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.daniel.aula11.entity.Contato;

import java.util.List;

@Dao
public interface ContatoDAO { // ---------------------------------------------------------------------interface é uma classe abstrata
    @Insert
    void salvar(Contato contato);

    @Query("SELECT * FROM Contato")
    List<Contato> getContatos();

    @Delete
    void excluir(Contato contato);

    @Update
    void editar(Contato contato);

}
