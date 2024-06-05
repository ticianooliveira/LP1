package com.ticiano.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer numeroDoQuarto;

    private Date dataEntrada;

    private Date dataSaida;

    private Long result;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroDoQuarto, Date dataEntrada, Date dataSaida) {
        this.numeroDoQuarto = numeroDoQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Integer getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(Integer numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }
    public Date getDataSaida() {
        return dataSaida;
    }

    public long duracao() {
        long diferenca = dataSaida.getTime() - dataEntrada.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public void atualizacaoDatas(Date entrada,Date saida) {
        Date agora = new Date();
        if(entrada.before(agora) && saida.before(agora)) {

        }
        if (!saida.after(entrada)) {
//            throw new DomainException("Erro na reserva: A data de entrada tem que ser maior que a saida ");
        }
        this.dataEntrada = entrada;
        this.dataSaida = saida;
    }
    public long valor () {
        result = duracao()*100;
        return result;
    }

    public String toString() {
        return  " Número do quarto: " + numeroDoQuarto +
                "\n Data de entrada: " + sdf.format(dataEntrada) +
                "\n Data de Saida: " + sdf.format(dataSaida) + "\n Valor Total: " + valor();

    }
}
