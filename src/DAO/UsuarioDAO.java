package dao;

import main.Conexao;
import java.sql.*;

public class UsuarioDAO {

    public boolean login(String user, String senha) {
        String sql = "SELECT * FROM usuario WHERE login=? AND senha=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}