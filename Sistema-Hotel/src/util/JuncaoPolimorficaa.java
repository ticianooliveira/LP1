package util;

import model.entities.Person;
import model.entities.Reservation;

public class JuncaoPolimorficaa {
    public void Juncao(Reservation reserv, Person person) {
        System.out.println("Noites :" +reserv.duracao()+" Nome :"+person.getNome()+" "+"NumeroCtt :"+person.getNumero()+" "+"CPF :"+ person.getCpf());

    }

}
