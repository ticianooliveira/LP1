package com.ticiano.model;

public class Cliente extends Pessoa implements interfaceLogic{

    private int numDeInscricao;

    public Cliente() {}

    public Cliente(String nome, String cpf, Integer numero, int numDeInscricao) {
        super(nome, cpf, numero);
        this.numDeInscricao = numDeInscricao;
    }

    public int getNumDeInscricao() {
        return numDeInscricao;
    }

    public void setNumDeInscricao(int numDeInscricao) {
        this.numDeInscricao = numDeInscricao;
    }
    @Override
    public void DescontoDaAssociacao(long valor) {
        double resul = valor * 1.5;
        System.out.println("Valor do deconto :" + resul);

    }

    public String toString() {
        return "Cliente Consumidor [numDeInscricao=" + numDeInscricao + ", nome=" + nome + ", numero="
                + numero + "]" ;
    }
}
