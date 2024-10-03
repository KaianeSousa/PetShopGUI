public class ConsultaVeterinaria extends Servico {
    private String veterinario; // Nome do veterinário responsável
    private String tipoConsulta; // Tipo da consulta (geral, especialidade, emergência)

    // Construtor para consulta veterinária
    public ConsultaVeterinaria(double preco, String veterinario, String tipoConsulta) {
        super("Consulta Veterinária", preco);
        this.veterinario = veterinario;
        this.tipoConsulta = tipoConsulta;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    @Override
    public String detalhes() {
        return super.detalhes() + " com o veterinário: " + veterinario + ", tipo de consulta: " + tipoConsulta + ".";
    }
}
