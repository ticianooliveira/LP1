package com.ticiano.utils;

import com.ticiano.model.Pessoa;
import com.ticiano.model.Reserva;

public class JuncaoPolimorfica {
    public void Juncao(Reserva reserv, Pessoa person) {
        System.out.println("Noites :" +reserv.duracao()+" Nome :"+person.getNome()+" "+"NumeroCtt :"+person.getNumero()+" "+"CPF :"+ person.getCpf());

    }
}
