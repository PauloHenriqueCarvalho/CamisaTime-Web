/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.Usuario;

/**
 *
 * @author Joao Guilherme
 */
public class UsuarioDAO {

    /*
    try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("");
            rs = stmt.executeQuery();

            if (rs.next()) {

            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
     */
    public Usuario validaUser(Usuario user) {
        Usuario usuarioValido = new Usuario();
        try {
            Connection con = Conexao.getConn();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();

            if (rs.next()) {
                usuarioValido.setIdUsuario(rs.getInt("idusuario"));
                usuarioValido.setNome(rs.getString("nome"));
                usuarioValido.setEmail(rs.getString("email"));
                usuarioValido.setTelefone(rs.getString("telefone"));
                usuarioValido.setCpf(rs.getString("cpf"));
                Usuario.setIdUsuarioStatico(rs.getInt("idUsuario"));

            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            usuarioValido.setIdUsuario(0);
            usuarioValido.setNome("");
            usuarioValido.setEmail("");
        }
        return usuarioValido;
    }

    public int getId(String user) {
        int id = 0;
        try {
            Connection con = Conexao.getConn();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ?");
            stmt.setString(1, user);

            rs = stmt.executeQuery();

            if (rs.next()) {
                
                id = rs.getInt("idUsuario");

            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public Usuario getName(int id) {
        Usuario u = null;

        try {
            Connection con = Conexao.getConn();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                // Aqui você precisa instanciar um objeto Usuario
                u = new Usuario();
                u.setNome(rs.getString("nome"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public Usuario getUsuarioByEmail(String email) {
        Usuario u = new Usuario();
        try {
            java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE email = ?");
            stmt.setString(1, email);

            rs = stmt.executeQuery();

            if (rs.next()) {
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setEmail(email);
                u.setTelefone(rs.getString("telefone"));
                u.setCpf(rs.getString("cpf"));
            } else {
                System.out.println("Usuario não localizado.");
            }

            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    public int create(Usuario u) {
        int id = 0;
        try {
            java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO usuario (nome, email, senha, cpf, telefone) values (?, ?, ?, ?, ?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getTelefone());

            stmt.executeUpdate();
            stmt.close();
            
            PreparedStatement stmt2 = null;
            stmt2 = conexao.prepareStatement("select * from usuario where nome = ? and email = ? and senha = ? and cpf = ? and telefone = ? ");
            stmt2.setString(1, u.getNome());
            stmt2.setString(2, u.getEmail());
            stmt2.setString(3, u.getSenha());
            stmt2.setString(4, u.getCpf());
            stmt2.setString(5, u.getTelefone());
            ResultSet rs = stmt2.executeQuery();
            if(rs.next()){
                id = rs.getInt("idUsuario");
            }
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void update(Usuario u) {
        try {
            java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ?, cpf = ?, telefone = ? WHERE idUsuario = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getTelefone());
            stmt.setInt(6, u.getIdUsuario());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Usuario u) {
        try {
            java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ?, cpf = ?, telefone = ? WHERE idUsuario = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, "");
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getTelefone());
            stmt.setInt(6, u.getIdUsuario());

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
