package model;


public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private int ano;
    private int quantidade;

    public Livro(int id, String titulo, String autor, String genero, int ano, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ano = ano;
        this.quantidade = quantidade;
    }

    public void emprestar() {
        if (quantidade > 0) {
            quantidade--;
        } else {
            System.out.println("Livro indisponível!");
        }
    }

    public void devolver() {
        quantidade++;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getAno() {
        return ano;
    }
    
    @Override
public String toString() {
    return titulo; 
}
    
    
}
