package entities;

public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private String senha;

    public Cliente(String nome, String telefone, String email, String endereco, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
    }

    public Cliente() {

    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
    }

    public void setTelefone(String telefone) {
    }

    public void setEmail(String email) {
    }

    public void setEndereco(String endereco) {
    }

    public void setSenha(String senha) {
    }
}
