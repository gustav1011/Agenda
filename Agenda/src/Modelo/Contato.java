package modelo;

public class Contato extends Pessoa {
    private String email;
    private String telefone;
    private String tipoCtt;
  
    public Contato(String nome, String endereco, String cpf, String email, String telefone,String tipoCtt) {
      super(nome, endereco, cpf);
      this.email = email;
      this.telefone = telefone;
      this.tipoCtt = tipoCtt;
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

    public String getTipoCtt() {
      return tipoCtt;
  }

  public void setTipoCtt(String tipoCtt) {
      this.tipoCtt = tipoCtt;
  }

  
    @Override
    public String toString() {
      String pessoaToString = super.toString();
      return pessoaToString + "\n" + "Email:" + this.email + "\n" +
          "Telefone: " + this.telefone + ".";
    }
  
  }
  