package model.entities;

public class Person {

    protected String nome;

    protected String cpf ;

    protected Integer numero;

    public Person(){}

    public Person(String nome, String cpf, Integer numero) {
        this.nome = nome;
        this.cpf = cpf;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
