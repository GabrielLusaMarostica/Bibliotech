package model;

public class Aluno {
    private int id;
    private String nome;
    private String matricula;
    private String serie;
    private String contato;

    public Aluno(int id, String nome, String matricula, String serie, String contato) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.serie = serie;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }
}
