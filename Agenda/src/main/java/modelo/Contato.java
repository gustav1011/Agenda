package modelo;

public class Contato {
    private String nome;
    private String email;
    private String telefone;
    private String tipoCtt; // Tipo de contato (FAMILIA, AMIGO, etc.)

    // Construtor
    public Contato(String nome, String email, String telefone, String tipoCtt) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoCtt = tipoCtt;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
