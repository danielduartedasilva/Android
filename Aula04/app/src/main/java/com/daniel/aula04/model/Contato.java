package com.daniel.aula04.model;

public class Contato {

    private String nome;
    private String telefone;
    private String email;

    public Contato() {//para criar objeto vazio
    }

    public Contato(String nome, String telefone, String email) {//para criar objeto com os dados preenchidos
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {//a maneira como vc quer exibir os dados na tela é usando o toString. Quando criamos o list view e fizermos o ToString inserir os contatos neste list view, ele vai acessar o array list de contatos, vai pegar os objetos tipo contato e preencher a lista. Ele preenche a lista pegando o toString desses objetos
        return this.nome;
    }
}
