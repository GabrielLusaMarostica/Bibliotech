package dao;

import model.Funcionario;
import main.Conexao;
import java.sql.*;
import java.util.ArrayList;

public class FuncionarioDAO {

    public void inserir(Funcionario f) {
        String sql = "INSERT INTO funcionario (nome, matricula, funcao) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getMatricula());
            stmt.setString(3, f.getFuncao());

            stmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Funcionario> listar() {
        ArrayList<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Funcionario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("matricula"),
                    rs.getString("funcao")
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }
}