package entities;

public class Tosa extends Servico {
    private int tipoCorte; // duração do banho em minutos

    // Tosa total, tosa higiênica, tosa estética
    public Tosa(double preco, int tipoCorte) {
        super("Tosa", preco);
        this.tipoCorte = tipoCorte;
    }

    public int getTipo() {
        return tipoCorte;
    }


    }


