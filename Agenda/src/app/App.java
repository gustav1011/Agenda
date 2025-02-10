package app;

import DAO.AgendaDAO;
import Modelo.*;
import java.util.HashSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AgendaDAO agendaDAO = new AgendaDAO();
        Agenda agenda = new Agenda();
        HashSet<Contato> contatos = new HashSet<>();
        Scanner in = new Scanner(System.in);

        System.out.println("Deseja adicionar uma agenda no banco? (sim/não)");
        String resposta = in.nextLine();

        if (resposta.equalsIgnoreCase("sim")) {
            System.out.println("--DIGITE O NOME DA AGENDA-- ");
            agenda.setNome(in.nextLine());

            System.out.println("--ADICIONAR CONTATOS--");
            System.out.print("Quantos contatos deseja adicionar? ");
            int qtdContatos = in.nextInt();
            in.nextLine(); // Consumir o newline

            for (int i = 0; i < qtdContatos; i++) {
                System.out.println("Contato " + (i + 1) + ":");
                System.out.print("Nome: ");
                String nomeContato = in.nextLine();

                System.out.print("Email: ");
                String email = in.nextLine();

                System.out.print("Telefone: ");
                String telefone = in.nextLine();

                System.out.print("Tipo de Contato (Ex: FAMILIA, AMIGO): ");
                String tipo = in.nextLine();

                contatos.add(new Contato(nomeContato, email, telefone, tipo));
            }
            agenda.setContatos(contatos);
            agendaDAO.insert(agenda);
            System.out.println("Agenda salva com sucesso!");
        }
        
        System.out.println("Deseja buscar alguma Agenda no Banco de Dados? (sim/não)");
        String resposta1 = in.nextLine();
        if (resposta1.equalsIgnoreCase("sim")) {
            System.out.println("Você deseja buscar por ID ou por Nome?");
            String tipoBusca = in.nextLine();

            if (tipoBusca.equalsIgnoreCase("id")) {
                System.out.print("Digite a ID da agenda: ");
                int idBuscado = in.nextInt();
                in.nextLine(); // Consumir o newline
                agendaDAO.selectById(idBuscado, agenda);
            } else if (tipoBusca.equalsIgnoreCase("nome")) {
                System.out.print("Digite o nome da agenda: ");
                String nomeBuscado = in.nextLine();
                agendaDAO.selectByName(nomeBuscado, agenda);
            } else {
                System.out.println("Opção inválida.");
            }
        }
        
        System.out.println("Deseja atualizar alguma Agenda? (sim/não)");
        String resposta2 = in.nextLine();
        if (resposta2.equalsIgnoreCase("sim")) {
            System.out.print("Digite o nome da agenda que deseja atualizar: ");
            String nomeBuscado = in.nextLine();
            agendaDAO.selectByName(nomeBuscado, agenda);

            System.out.print("Digite o novo nome da agenda: ");
            String novoNome = in.nextLine();
            
            System.out.print("Digite a ID da agenda: ");
            int id = in.nextInt();
            in.nextLine(); // Consumir o newline

            agendaDAO.UpdateName(agenda, id, novoNome);
            System.out.println("Agenda atualizada com sucesso!");
        }
        
        System.out.println("Deseja deletar alguma Agenda? (sim/não)");
        String resposta3 = in.nextLine();
        if (resposta3.equalsIgnoreCase("sim")) {
            System.out.print("Digite o nome da agenda que deseja deletar: ");
            String nomeDeletado = in.nextLine();
            agendaDAO.delete(nomeDeletado);
            System.out.println("Agenda deletada com sucesso!");
        }

        in.close();
    }
}
