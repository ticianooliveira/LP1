package model.entities;

public class SimpleClient extends Person {

    private int numDaConta;

    public SimpleClient(String nome, String cpf, Integer numero, int numDaConta) {
        super(nome, cpf, numero);
        this.numDaConta = numDaConta;
    }

    public int getNumDaConta() {
        return numDaConta;
    }

    public void setNumDaConta(int numDaConta) {
        this.numDaConta = numDaConta;
    }

    @Override
    public String toString() {
        return "SimpleClient [numDaConta=" + numDaConta + ", nome=" + nome + ", numero=" + numero
                + "]";
    }
}
