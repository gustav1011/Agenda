
public class Pessoa {// superclasse
  //private int id;
  private String nome;
  private String endereco;
  private String cpf;

  public Pessoa(String nome, String endereco, String cpf) {// para usar o super devemos delclarar o construtor da
                                                           // superclasse
    this.nome = nome;
    this.endereco = endereco;
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String toString() {
    return "Nome: " + this.nome + "\n " +
        "Endereço: " + this.endereco + "\n" +
        "CPF: " + this.cpf;
  }

}
