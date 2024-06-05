package com.ticiano;

import com.ticiano.model.Cliente;
import com.ticiano.model.Consumidor;
import com.ticiano.model.Pessoa;
import com.ticiano.model.Reserva;
import com.ticiano.utils.JuncaoPolimorfica;
import com.ticiano.utils.ListaUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ListaUtil<Pessoa> pessoa = new ListaUtil<Pessoa>();

        JuncaoPolimorfica jn = new JuncaoPolimorfica();

            int numDeInscricao = 0;

                System.out.println("digite o nome do Cliente :");
                String nome = sc.next();
                System.out.println("digite o cpf do mesmo :");
                String cpf = sc.next();
                System.out.println("digite o número para contato :");
                Integer numeroContato = sc.nextInt();
                System.out.print("Informe o número do quarto :");
                int numero = sc.nextInt();
                System.out.print("Qual a Data de entrada :");
                Date entrada = sdf.parse(sc.next());
                System.out.print("qual a Data de Saída :");
                Date saida = sdf.parse(sc.next());

                System.out.println("A pessoa é associada ao Hotel ? S/N");
                char escolha = sc.next().toLowerCase().charAt(0);

                if (escolha == 's') {

                    System.out.println("Informe o número de inscrição da filiação :");
                    numDeInscricao = sc.nextInt();
                    Cliente ps = new Cliente(nome, cpf, numeroContato, numDeInscricao);
                    System.out.println("informe qual o valor do desconto");
                    double a = sc.nextDouble();
                    ps.DescontoDaAssociacao((long)a);
                    pessoa.adicionar(ps);
                } else {
                    System.out.println("Informe o numero da conta :");
                    int numDaConta = sc.nextInt();
                    Pessoa client = new Pessoa(nome, cpf, numeroContato);
                    pessoa.adicionar(client);
                }

                Reserva reserva = new Reserva(numero, entrada, saida);
                System.out.println("Reserva :\n" + reserva);
                jn.Juncao(reserva, new Consumidor(nome,cpf,numeroContato,numDeInscricao));

                System.out.println("Quer atualizar a reserva ?");
                char reserv = sc.next().toLowerCase().charAt(0);
                if (reserv == 's') {
                    System.out.println("Entre com as novas datas da reserva");
                    System.out.print("Qual a Data de entrada :");
                    entrada = sdf.parse(sc.next());
                    System.out.print("qual a Data de Saída :");
                    saida = sdf.parse(sc.next());

                    reserva.atualizacaoDatas(entrada, saida);
                    System.out.println("Reserva :\n" + reserva);
                } else {
                    System.out.println("chegamos ao final do cadastro");
                }
                System.out.println("quer fazer outro cadastro ? "+ "\n" + "Digite s/n");

//                x = sc.next().charAt(0);

            System.out.println("Listando todos os usuarios do hotel");
            pessoa.listarTodos();


        sc.close();
    }
}
