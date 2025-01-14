package Modelo;


import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;

//import Agenda;

import java.util.*;

 //importei cada classe que eu usei só para deixar mais claro o que eu estou fazendo e usando

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    try {
      System.out.println("--DIGITE O NOME DA AGENDA-- ");
      String nome = in.nextLine();
      Agenda agenda = new Agenda(nome);

      HashSet<Contato> contatos = new HashSet<Contato>(); // Inicialização da lista, usando Hashset para nao permitir dois contatos iguais!!!

      int nContatos = 0;

      boolean validInput = false;
      while (!validInput) {
        try {
          System.out.println("Quantos contatos deseja adicionar?");
          nContatos = in.nextInt();
          validInput = true;
        } catch (InputMismatchException e1) {
          System.out.println(e1.getMessage());
          e1.printStackTrace();
          System.out.println("Digite um número inteiro!(ex:1,2,3...)");
          in.nextLine(); // Limpa a entrada inválida
        }
      }
      in.nextLine(); // Consome a nova linha após o inteiro

      int escolhatipo;
      for (int i = 0; i < nContatos; i++) {
        System.out.println("Escolha o Tipo do contato:\n (1) FAMILIAR\n (2) COMERCIAL\n (3) RESIDENCIAL");
        escolhatipo = in.nextInt();
        in.nextLine(); // Consome a nova linha após o inteiro
        if(escolhatipo == 1){
          System.out.println("Tipo: Familiar");
        } else if(escolhatipo == 2){
          System.out.println("Tipo: Comercial");
        } else if(escolhatipo == 3){
          System.out.println("Tipo: Residencial");
        } else{
          System.out.println("Tipo inválido! Tente novamente.");
        }
        System.out.println("--DIGITE AS INFORMAÇÔES DO CONTATO--");
        String nomeContato;
        String sobreNomeCtt;
        while (true) {
          System.out.println("Digite o nome do contato: ");
          nomeContato = in.nextLine();
          System.out.println("Digite o Sobrenome: ");
          sobreNomeCtt = in.nextLine();
          String joined = nomeContato + " " + sobreNomeCtt;
          System.out.println("Nome Completo: " + joined);
          if (nomeContato.matches("[a-zA-Z]+")) {
            break;
          } else {
            System.out.println("Nome inválido, apenas letras são aceitas, digite novamente!");
          }
        }

        System.out.println("Digite o Endereço do contato: ");
        String enderecoCtt = in.nextLine();

        String cpfCtt;
        while (true) {
          System.out.println("Digite o CPF do contato: ");
          cpfCtt = in.nextLine();
          if (cpfCtt.matches("\\d{11}")) {
            break;
          } else {
            System.out.println("CPF inválido, digite novamente!(são 11 números)");
          }
        }

        System.out.println("Digite o email do contato: ");
        String email = in.nextLine();

        String telefone;
        while (true) {// while(true) é um loop infinito até o break!
          System.out.println("Digite o telefone do contato (sem o DDD): ");
          telefone = in.nextLine();
          if (telefone.matches("\\d{9}")) {
            break;
          } else {
            System.out.println("Número inválido, apenas números são aceitos, digite novamente!");
          }
        }
        Contato ctt1 = new Contato(nomeContato, enderecoCtt, cpfCtt, email, telefone);
        contatos.add(ctt1);
      }

      agenda.setContatos(contatos);
      System.out.println(" ");

      if (agenda != null) {
        System.out.println(agenda.toString());
        System.out.println(" ");
      }

      System.out.println("Você deseja buscar algum nome na agenda?");
      String resposta1 = in.nextLine();
      if (resposta1.equalsIgnoreCase("sim")) {
        System.out.println("Digite o nome do contato que deseja buscar:");
        String nomeBuscado = in.nextLine();
        Contato resultadoDaBusca = agenda.buscarPorNome(nomeBuscado);
        if (resultadoDaBusca != null) {
          System.out.println("Contato encontrado: " + resultadoDaBusca);
        } else {
          System.out.println("Contato não encontrado.");
        }
      } else if (resposta1.equalsIgnoreCase("não") || resposta1.equalsIgnoreCase("nao")) {
        System.out.println("Etapa pulada");
      } else {
        System.out.println("Resposta inválida. Etapa pulada.");
      }

      System.out.println("Você deseja buscar algum email na agenda?");
      String resposta7 = in.nextLine();
      if (resposta7.equalsIgnoreCase("sim")) {
        System.out.println("Digite o email do contato que deseja buscar:");
        String emailBuscado = in.nextLine();
        Contato resultadoDaBusca2 = agenda.buscarPorEmail(emailBuscado);
        if (resultadoDaBusca2 != null) {
          System.out.println("Email encontrado: " + resultadoDaBusca2);
        } else {
          System.out.println("Email não encontrado.");
        }
      } else if (resposta7.equalsIgnoreCase("não")) {
        System.out.println("Etapa pulada");
      } else {
        System.out.println("Resposta inválida. Etapa pulada.");
      }

      System.out.println("Você deseja buscar algum telefone na agenda?");
      String resposta3 = in.nextLine();
      if (resposta3.equalsIgnoreCase("sim")) {
        System.out.println("Digite o telefone que deseja buscar:");
        String telefoneBuscado = in.nextLine();
        Contato resultadoTelefone = agenda.buscarPorTelefone(telefoneBuscado);
        if (resultadoTelefone != null) {
          System.out.println("Telefone encontrado: " + resultadoTelefone);
        } else {
          System.out.println("Telefone não encontrado.");
        }
      } else if (resposta3.equalsIgnoreCase("não") || resposta3.equalsIgnoreCase("nao")) {
        System.out.println("Etapa pulada");
      } else {
        System.out.println("Resposta inválida. Etapa pulada.");
      }

      System.out.println("Deseja excluir algum contato da sua agenda?");
      String resposta5 = in.nextLine();
      if (resposta5.equalsIgnoreCase("sim")) {
        System.out.println("Digite o nome do contato que deseja excluir:");
        String excluir = in.nextLine(); // Solicita o nome do contato a ser excluído
        Contato resultadoexclu = agenda.deletarContato(excluir);
        if (resultadoexclu != null) {
          System.out.println("Contato: " + resultadoexclu + " excluído com sucesso!");
        } else {
          System.out.println("Contato não encontrado!");
        }
      } else if (resposta5.equalsIgnoreCase("não")) {
        System.out.println("Etapa pulada");
      } else {
        System.out.println("Resposta inválida. Etapa pulada!");
      }

      System.out.println("Deseja excluir todos contatos da agenda?");
      String resposta6 = in.nextLine();
      if (resposta6.equalsIgnoreCase("sim")) {
        agenda.removerTodosOsContatos();
        System.out.println("Agenda excluída com sucesso!");
      } else {
        System.out.println("Agenda não excluída!");
      }
    } catch (Exception e) {
      System.out.println("Erro inesperado: " + e.getMessage());
      e.printStackTrace();
    } finally {
      in.close();
    }
  }
}
