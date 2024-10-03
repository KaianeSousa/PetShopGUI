public class Servico {
    private String nomeServico;
    private double preco;

    public Servico(String nomeServico, double preco) {
        this.nomeServico = nomeServico;
        this.preco = preco;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public double getPreco() {
        return preco;
    }

    public String detalhes() {
        return "Serviço: " + nomeServico + ", Preço: " + preco;
    }
}
