package entities;

public class Animal {
    private String nome;
    private int raca;
    private int idade;
    private Cliente dono;

    public Animal(String nome, int idade, Cliente dono) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Cliente getDono() {
        return dono;
    }
}
