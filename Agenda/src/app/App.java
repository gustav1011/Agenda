package app;

import modelo.*;
import DAO.*;

import java.util.HashSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AgendaDAO agendaDAO = new AgendaDAO();

        Agenda agenda = new Agenda();

        HashSet<Contato> contatos = new HashSet<Contato>();

        // Entrada de dados para a agenda
        Scanner in = new Scanner(System.in);
        System.out.println("--DIGITE O NOME DA AGENDA-- ");
        String nome = in.nextLine();
        agenda.setNome(nome);

        // Adicionar contatos manualmente (Exemplo)
        System.out.println("--ADICIONAR CONTATOS--");
        System.out.print("Quantos contatos deseja adicionar? ");
        int qtdContatos = in.nextInt();
        in.nextLine(); // Consumir o newline


        String escolhanome;
        String escolhaemail;
        String escolhaTel;
        String escolhatipo;

        //escolhatipo,nomeContato, enderecoCtt, cpfCtt, email, telefone
        

        for (int i = 0; i < qtdContatos; i++) {
            System.out.println("Contato " + (i + 1) + ":");
            
            System.out.print("Nome: ");
            escolhanome = in.nextLine();
        
            System.out.println("Email: ");
            escolhaemail = in.nextLine();

            System.out.println("Telefone: ");
            escolhaTel = in.nextLine();

            System.out.println("Tipo de Contato (Ex: FAMILIA, AMIGO): ");
            escolhatipo = in.nextLine();

            //contato.setNome(in.nextLine());
            //System.out.print("Email: ");

            //contato.setEmail(in.nextLine());
            //System.out.print("Telefone: ");

            //contato.setTelefone(in.nextLine());

            //System.out.print("Tipo de Contato (Ex: FAMILIA, AMIGO): ");
            //contato.setTipoCtt(in.nextLine()); // Adapte conforme a enum

            Contato ctt1 = new Contato(escolhanome, escolhaemail,escolhaTel,escolhatipo);
            contatos.add(ctt1);

            agenda.setContatos(contatos); // Adiciona o contato à agenda
        }

        agendaDAO.insert(agenda); // Insere a agenda no banco de dados

        System.out.println("Agenda salva com sucesso!");
        in.close();
    }
}
