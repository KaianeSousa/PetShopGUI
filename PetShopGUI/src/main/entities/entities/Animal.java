package entities;

public class Animal {
    private String nome;
    private String raca;
    private String tipo;
    private int idade;
    private Cliente dono;


    public Animal(String nome, String raca,  String tipo, int idade, Cliente dono) {
        this.nome = nome;
        this.raca = raca;
        this.tipo = tipo;
        this.idade = idade;
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public String getTipo() {
        return tipo;
    }

    public int getIdade() {
        return idade;
    }

    public Cliente getDono() {
        return dono;
    }

}
