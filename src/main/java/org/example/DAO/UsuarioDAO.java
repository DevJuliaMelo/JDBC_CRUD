package org.example.DAO;

import org.example.conect.Conexao;
import org.example.entity.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (NOME, LOGIN, SENHA, EMAIL) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getEmail());

            ps.execute();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE USUARIO SET NOME = ?, LOGIN = ?, SENHA = ?, EMAIL = ? WHERE USUARIO = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getEmail());
            ps.setInt(5, usuario.getUsuario());

            ps.executeUpdate();
            System.out.println("Usuário atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void excluirUsuario(int usuario) {
        String sql = "DELETE FROM USUARIO WHERE USUARIO = ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, usuario);

            ps.executeUpdate();
            System.out.println("Usuário excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
