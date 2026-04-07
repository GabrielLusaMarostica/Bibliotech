package dao;

import model.ItemEmprestimo;
import main.Conexao;
import java.sql.*;

public class ItemEmprestimoDAO {

    public ItemEmprestimoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void inserir(ItemEmprestimo item, int idEmprestimo) {
        String sql = "INSERT INTO item_emprestimo (id_emprestimo, id_livro, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEmprestimo);
            stmt.setInt(2, item.getLivro().getId());
            stmt.setInt(3, item.getQuantidade());

            stmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}