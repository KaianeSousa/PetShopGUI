package entities;

public class Animal {
    private String nome;
    private String raca;
    private String tipo;
    private String idade;


    public Animal(String nome, String raca,  String tipo, String idade) {
        this.nome = nome;
        this.raca = raca;
        this.tipo = tipo;
        this.idade = idade;
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

    public String getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int i) {
    }

    public void setRaca(String text) {
    }

    public void setTipo(String text) {
    }
}
