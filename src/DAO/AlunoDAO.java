package dao;

import model.Aluno;
import main.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class AlunoDAO {

    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, matricula, serie, contato) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getMatricula());
            stmt.setString(3, aluno.getSerie());
            stmt.setString(4, aluno.getContato());

            stmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Aluno> listar() {
        ArrayList<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluno";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Aluno a = new Aluno(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("matricula"),
                    rs.getString("serie"),
                    rs.getString("contato")
                );
                lista.add(a);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }
    
    public void atualizar(Aluno aluno) {
    String sql = "UPDATE aluno SET nome=?, matricula=?, serie=?, contato=? WHERE id=?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getMatricula());
        stmt.setString(3, aluno.getSerie());
        stmt.setString(4, aluno.getContato());
        stmt.setInt(5, aluno.getId());

        stmt.execute();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }
    
    public void excluir(int id) {
    String sql = "DELETE FROM aluno WHERE id=?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        stmt.execute();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    
    
}
   
    
}