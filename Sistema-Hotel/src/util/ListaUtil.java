package util;

import java.util.ArrayList;
import java.util.List;

public class ListaUtil <T>{

    List<T> lista = new ArrayList<T>();


    public void adicionar (T tipo) {
        lista.add(tipo);
    }

    public void listarTodos() {
        for (T tipo : lista){
            System.out.println(tipo);

        }
    }



}
