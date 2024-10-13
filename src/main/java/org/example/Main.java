package org.example;

import org.example.DAO.UsuarioDAO;
import org.example.entity.Usuario;

public class Main {
    public static void main(String[] args) throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario u = new Usuario();

        u.setUsuario(0);
        u.setNome("BEATRIZ");
        u.setLogin("BEA");
        u.setSenha("123456");
        u.setEmail("BEA@gmail.com");
        usuarioDAO.atualizarUsuario(u);
        new UsuarioDAO().cadastrarUsuario(u);

        usuarioDAO.excluirUsuario(0);
    }
}