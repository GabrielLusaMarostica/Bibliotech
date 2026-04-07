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

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public double getMulta() {
        return multa;
    }

    
    
    
}
