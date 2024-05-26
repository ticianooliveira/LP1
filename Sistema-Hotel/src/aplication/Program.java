package aplication;

import model.entities.AssociatedCustomer;
import model.entities.Person;
import model.entities.Reservation;
import model.entities.SimpleClient;
import model.exceptions.DomainException;
import util.JuncaoPolimorficaa;
import util.ListaUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    ListaUtil<Person> pessoa = new ListaUtil<Person>();


		try {
        char x;
        int numDeInscricao = 0;
        JuncaoPolimorficaa jn = new JuncaoPolimorficaa();
        do {
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
                AssociatedCustomer ps = new AssociatedCustomer(nome, cpf, numeroContato, numDeInscricao);
                System.out.println("informe qual o valor do desconto");
                double a = sc.nextDouble();
                ps.DescontoDaAssociacao((long)a);
                pessoa.adicionar(ps);



            } else {
                System.out.println("Informe o numero da conta :");
                int numDaConta = sc.nextInt();
                SimpleClient client = new SimpleClient(nome, cpf, numeroContato, numDaConta);
                pessoa.adicionar(client);
            }

            Reservation reserva = new Reservation(numero, entrada, saida);
            System.out.println("Reserva :\n" + reserva);
            jn.Juncao(reserva, new AssociatedCustomer(nome,cpf,numeroContato,numDeInscricao));

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

            x = sc.next().charAt(0);
        }while(x == 's');
        System.out.println("Listando todos os usuarios do hotel");
        pessoa.listarTodos();

    } catch (ParseException e) {
        System.out.println("Data invalida");
    } catch (DomainException e) {
        System.out.println("Erro na reserva: " + e.getMessage());
    } catch (RuntimeException e) {
        System.out.println("Erro inesperado");
    }
        sc.close();
}
}
