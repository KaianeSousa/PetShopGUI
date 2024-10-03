package entities;

public class Servico {
    private String nomeServico;
    private double preco;

    public Servico(String nomeServico, double preco) {
        this.nomeServico = nomeServico;
        this.preco = preco;
    }

    // Métodos para retornar informações do serviço
    public String getnomeServico() { // De sangue, urina
        return nomeServico;
    }

    public double getPreco() {
        return preco;
    }
}
