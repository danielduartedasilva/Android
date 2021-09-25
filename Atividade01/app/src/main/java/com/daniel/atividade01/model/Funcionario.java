package com.daniel.atividade01.model;

public class Funcionario {
    private String nome;
    private float salarioBruto;
    private float ir;
    private float inss;
    private float fgts;
    private float salarioLiquido;
    private int horasTrabalhadas;
    private float valorHora;

    public Funcionario() {
    }

    public Funcionario(String nome, float salarioBruto, float ir, float inss, float fgts, float salarioLiquido, int horasTrabalhadas, float valorHora) {
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        this.ir = ir;
        this.inss = inss;
        this.fgts = fgts;
        this.salarioLiquido = salarioLiquido;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public float getIr() {
        return ir;
    }

    public void setIr(float ir) {
        this.ir = ir;
    }

    public float getInss() {
        return inss;
    }

    public void setInss(float inss) {
        this.inss = inss;
    }

    public float getFgts() {
        return fgts;
    }

    public void setFgts(float fgts) {
        this.fgts = fgts;
    }

    public float getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(float salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
