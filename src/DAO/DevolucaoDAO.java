package dao;

import model.Devolucao;
import main.Conexao;
import java.sql.*;

public class DevolucaoDAO {

    public void inserir(Devolucao d) {
        String sql = "INSERT INTO devolucao (id_emprestimo, data_devolucao, dias_atraso, multa_total) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, d.getEmprestimo().getId());
            stmt.setDate(2, new java.sql.Date(d.getDataDevolucao().getTime()));
            stmt.setInt(3, d.getDiasAtraso());
            stmt.setDouble(4, d.getMulta());

            stmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}