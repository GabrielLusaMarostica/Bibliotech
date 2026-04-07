package model;

import java.util.ArrayList;
import java.util.Date;

public class Emprestimo {
    private int id;
    private Aluno aluno;
    private Funcionario funcionario;
    private Date dataEmprestimo;
    private Date dataPrevista;
    private ArrayList<ItemEmprestimo> itens;

    public Emprestimo(int id, Aluno aluno, Funcionario funcionario, Date dataEmprestimo, Date dataPrevista) {
        this.id = id;
        this.aluno = aluno;
        this.funcionario = funcionario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevista = dataPrevista;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemEmprestimo item) {
        itens.add(item);
        item.getLivro().emprestar();
    }

    public void mostrarResumo() {
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Funcionário: " + funcionario.getNome());
        System.out.println("Livros emprestados:");

        for (ItemEmprestimo item : itens) {
            System.out.println("- " + item.getLivro().getTitulo());
        }
    }
}
