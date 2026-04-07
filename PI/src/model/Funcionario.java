package model;

public class Funcionario {
    private int id;
    private String nome;
    private String matricula;
    private String funcao;

    public Funcionario(int id, String nome, String matricula, String funcao) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }
}
