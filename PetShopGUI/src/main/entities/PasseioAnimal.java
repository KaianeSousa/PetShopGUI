public class PasseioAnimal extends Servico {
    private int duracao;
    private String tipoPasseio;

    public PasseioAnimal(double preco, int duracao, String tipoPasseio) {
        super("Passeio Animais", preco);
        this.duracao = duracao;
        this.tipoPasseio = tipoPasseio;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getTipoPasseio() {
        return tipoPasseio;
    }

    @Override
    public String detalhes() {
        return super.detalhes() + " com duração de " + duracao + " minutos, tipo de passeio: " + tipoPasseio + ".";
    }
}
