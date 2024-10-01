public class Banho extends Servico {
    private int duracao;

    public Banho(double preco, int duracao) {
        super("Banho", preco);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String detalhes() {
        return super.detalhes() + " com duração " + duracao + ".";
    }