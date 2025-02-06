package Modelo;

import java.util.*;
import java.util.HashSet;

public class Agenda {
  private int id;
  private String nome;
  private HashSet<Contato> contatos;

  public Agenda(String nome) {
    this.nome = nome;
    this.contatos = new HashSet<Contato>();
  }

  public Agenda(){}


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public HashSet<Contato> getContatos() {
    return contatos;
  }

  public void setContatos(HashSet<Contato> contatos) {
    this.contatos = contatos;
  }

  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
  }

  @Override
  public String toString() {
    StringBuilder info = new StringBuilder("Nome da Agenda: " + this.nome + "\n");
    if (contatos != null) {
      for (Contato ctt : contatos) {
        info.append(ctt.toString()).append("\n");
      }
    }
    return info.toString();
  }

  public Contato buscarPorNome(String nome) {
    for (Contato ctt : contatos) {
      if (ctt.getNome().equalsIgnoreCase(nome)) {
        return ctt;
      }
    }
    System.out.println("Nome não encontrado na agenda!");
    return null;
  }

  public Contato buscarPorEmail(String email) {
    for (Contato ctt : contatos) {
      if (ctt.getEmail().equalsIgnoreCase(email)) {
        return ctt;
      }
    }
    System.out.println("Email não encontrado na agenda!");
    return null;
  }

  public Contato buscarPorTelefone(String telefone) {
    for (Contato ctt : contatos) {
      if (ctt.getTelefone().equalsIgnoreCase(telefone)) {
        return ctt;
      }
    }
    System.out.println("Telefone não encontrado na agenda!");
    return null;
  }

  public Contato atualizarCtt(String nome, String email, String telefone) {
    Contato c = buscarPorNome(nome);
    if (c != null) {
      c.setEmail(email);
      c.setTelefone(telefone);
      System.out.println("Contato atualizado!");
      return c;
    } else {
      System.out.println("Contato não encontrado!");
      return null;
    }
  }

  public Contato deletarContato(String nome) {
    Contato c = buscarPorNome(nome);
    if (c != null) {
      contatos.remove(c);
      return c;
    } else {
      System.out.println("Contato não encontrado");
      return null;
    }
  }

  public void removerTodosOsContatos() {
    contatos.clear();
    System.out.println("Todos os contatos foram removidos.");
  }

}
