package main;

import java.util.Date;
import model.*;


public class Main {

    public static void main(String[] args) {
        // Criando dados
        Livro livro1 = new Livro(1, "Java Básico", "Autor X", "Programação", 2020, 3);

        Aluno aluno = new Aluno(1, "Gabriel", "123", "3º Ano", "9999-9999");

        Funcionario funcionario = new Funcionario(1, "Carlos", "456", "Bibliotecário");

        // Criando empréstimo
        Emprestimo emprestimo = new Emprestimo(1, aluno, funcionario, new Date(), new Date());

        // Adicionando item
        ItemEmprestimo item = new ItemEmprestimo(livro1, 1);
        emprestimo.adicionarItem(item);

        // Mostrar resumo
        emprestimo.mostrarResumo();

        System.out.println("Quantidade restante do livro: " + livro1.getQuantidade());

        // Simulando devolução com atraso
        Devolucao devolucao = new Devolucao(emprestimo, new Date(), 3);
        devolucao.mostrarMulta();
    }
    
}
