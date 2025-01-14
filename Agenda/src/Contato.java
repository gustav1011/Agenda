
public class Contato extends Pessoa {
    private String email;
    private String telefone;
  
    public Contato(String nome, String endereco, String cpf, String email, String telefone) {
      super(nome, endereco, cpf);
      this.email = email;
      this.telefone = telefone;
    }
  
    public String getEmail() {
      return email;
    }
  
    public void setEmail(String email) {
      this.email = email;
    }
  
    public String getTelefone() {
      return telefone;
    }
  
    public void setTelefone(String telefone) {
      this.telefone = telefone;
    }
  
    @Override
    public String toString() {
      String pessoaToString = super.toString();
      return pessoaToString + "\n" + "Email:" + this.email + "\n" +
          "Telefone: " + this.telefone + ".";
    }
  
  }
  