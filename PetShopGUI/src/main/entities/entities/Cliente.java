package entities;

import java.util.UUID;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    public Cliente(int id, String nome, String telefone, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Cliente() {
        
    }

    public String getId() {
        return String.valueOf(id);
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

    public void setNome(String nome) {
    }

    public void setTelefone(String telefone) {
    }

    public void setEmail(String email) {
    }

    public void setEndereco(String endereco) {
    }

    public void setId(UUID id) {
    }
}

