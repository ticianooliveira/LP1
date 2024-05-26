package model.entities;

public class AssociatedCustomer extends Person implements interfaceLogic{

    private int numDeInscricao;

    public AssociatedCustomer() {}

    public AssociatedCustomer(String nome, String cpf, Integer numero, int numDeInscricao) {
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

    @Override
    public String toString() {
        return "AssociatedCustomer [numDeInscricao=" + numDeInscricao + ", nome=" + nome + ", numero="
                + numero + "]" ;
    }











}