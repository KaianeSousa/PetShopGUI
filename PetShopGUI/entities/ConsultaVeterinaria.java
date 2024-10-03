package entities;

public class ConsultaVeterinaria extends Servico {
    private String veterinario; // Nome do veterinário responsável
    private String tipoConsulta; // Tipo da consulta (geral, especialidade, emergência)

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

}
