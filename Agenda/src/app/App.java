package app;

import Modelo.*;
import DAO.AgendaDAO;

import java.util.HashSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AgendaDAO agendaDAO = new AgendaDAO();

        Agenda agenda = new Agenda();

        HashSet<Contato> contatos = new HashSet<Contato>();

        // Entrada de dados para a agenda
        Scanner in = new Scanner(System.in);

        
        System.out.println("Deseja adicionar uma agenda no banco?");
        String resposta=  in.nextLine();
        if(resposta.equalsIgnoreCase("sim")){

        System.out.println("--DIGITE O NOME DA AGENDA-- ");
        String nome = in.nextLine();
        agenda.setNome(nome);

        // Adicionar contatos manualmente 
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
        }else{

     System.out.println("Deseja buscar alguma Agenda no Banco de Dados? (sim/não)");
        String resposta1 = in.nextLine();

    while (!resposta1.equals("sim") && !resposta1.equals("não")) {
            System.out.println("Resposta inválida. Por favor, digite 'sim' ou 'não'.");
            resposta1 = in.nextLine();
        }
       if(resposta1.equalsIgnoreCase("sim")){
        System.out.println("Você deseja buscar por ID ou por Nome?");
        String tipoBusca = in.nextLine();
        while (!tipoBusca.equals("id") && !tipoBusca.equals("nome")){
        System.out.println("Opção inválida. Por favor, digite 'id' ou 'nome'.");
            if(tipoBusca.equalsIgnoreCase("id")){
    System.out.println("Digite a id que busca:");
    int idbuscada = in.nextInt();
        agendaDAO.selectById(idbuscada, agenda); //operação crud que faz select por id

    }else if(tipoBusca.equalsIgnoreCase("nome")){
        System.out.println("Digite o nome que busca:");
        String nomeBuscado = in.nextLine();
        agendaDAO.selectByName(nomeBuscado,agenda);//operação crud que faz select por nome
    }
        }
       }else{
         System.out.println("Você escolheu não buscar uma agenda no momento.");
        }
    }
        in.close();
    }
}
