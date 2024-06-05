package com.ticiano.model;

public class Consumidor extends Pessoa{
    private int numDaConta;

    public Consumidor(String nome, String cpf, Integer numero, int numDaConta) {
        super(nome, cpf, numero);
        this.numDaConta = numDaConta;
    }

    public int getNumDaConta() {
        return numDaConta;
    }

    public void setNumDaConta(int numDaConta) {
        this.numDaConta = numDaConta;
    }

    public String toString() {
        return "Consumidor [numDaConta=" + numDaConta + ", nome=" + nome + ", numero=" + numero
                + "]";
    }
}
