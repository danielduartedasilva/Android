package com.daniel.aula11.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Contato implements Serializable { // implements Serializable para permitir passar um objeto de uma intent para outra
    @PrimaryKey (autoGenerate = true) // ----------------------------------------------------------------------autoGenerate é tipo um autocomplete
    private int id;
    private String nome;
    private String fone;

    public Contato() { // -------------------------------------------------------------------------------construtor padrão
    }
    @Ignore // ------------------------------------------------------------------------------------------ o roon vai ignorar qualquer construtor que não seja o padrão
    public Contato(int id, String nome, String fone) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return this.nome + "\n(" + this.fone + ")";
    }
}
