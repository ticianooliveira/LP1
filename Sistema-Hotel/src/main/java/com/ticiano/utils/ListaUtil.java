package com.ticiano.utils;

import java.util.ArrayList;
import java.util.List;

public class ListaUtil <T>{

    List<T> lista = new ArrayList<>();


    public void adicionar (T tipo) {
        lista.add(tipo);
    }

    public void listarTodos() {
        for (T tipo : lista){
            System.out.println(tipo);

        }
    }
}
