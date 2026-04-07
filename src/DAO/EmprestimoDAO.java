package dao;

import model.Emprestimo;
import main.Conexao;
import java.sql.*;

public class EmprestimoDAO {

    public int inserir(Emprestimo e) {
        String sql = "INSERT INTO emprestimo (id_aluno, id_funcionario, data_emprestimo, data_prevista) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, e.getAluno().getId());
            stmt.setInt(2, e.getFuncionario().getId());
            stmt.setDate(3, new java.sql.Date(e.getDataEmprestimo().getTime()));
            stmt.setDate(4, new java.sql.Date(e.getDataPrevista().getTime()));

            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return 0;
    }
    
    public ResultSet listar() {
    String sql = "SELECT * FROM emprestimo";

    try {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        return stmt.executeQuery();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return null;
}

    
    
}