package model;

import java.util.Date;

public class Devolucao {
    private Emprestimo emprestimo;
    private Date dataDevolucao;
    private int diasAtraso;
    private double multa;

    public Devolucao(Emprestimo emprestimo, Date dataDevolucao, int diasAtraso) {
        this.emprestimo = emprestimo;
        this.dataDevolucao = dataDevolucao;
        this.diasAtraso = diasAtraso;
        this.multa = diasAtraso * 2.0; // R$2 por dia
    }

    public void mostrarMulta() {
        System.out.println("Dias de atraso: " + diasAtraso);
        System.out.println("Multa: R$ " + multa);
    }
}
