package dao;

import model.Livro;
import main.Conexao;
import java.sql.*;
import java.util.ArrayList;

public class LivroDAO {

    public void inserir(Livro l) {
        String sql = "INSERT INTO livro (titulo, autor, genero, ano, quantidade) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, l.getTitulo());
            stmt.setString(2, l.getAutor());
            stmt.setString(3, l.getGenero());
            stmt.setInt(4, l.getAno());
            stmt.setInt(5, l.getQuantidade());

            stmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Livro> listar() {
        ArrayList<Livro> lista = new ArrayList<>();
        String sql = "SELECT * FROM livro";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Livro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("genero"),
                    rs.getInt("ano"),
                    rs.getInt("quantidade")
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }
    
    public void atualizarQuantidade(int idLivro, int quantidade) {
    String sql = "UPDATE livro SET quantidade = quantidade - ? WHERE id=?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, quantidade);
        stmt.setInt(2, idLivro);

        stmt.execute();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
}