public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    // Construtor
    public Cliente(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    // Métodos para obter as informações do cliente
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

    // Método para exibir as informações do cliente
    public String detalhesCliente() {
        return "Nome: " + nome + "\n" +
                "Telefone: " + telefone + "\n" +
                "E-mail: " + email + "\n" +
                "Endereço: " + endereco;
    }
}
