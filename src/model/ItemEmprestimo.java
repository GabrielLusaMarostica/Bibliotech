package model;

public class ItemEmprestimo {
    private Livro livro;
    private int quantidade;

    public ItemEmprestimo(Livro livro, int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
