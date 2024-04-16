/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Categoria;
import model.bean.Subcategoria;

/**
 *
 * @author Senai
 */
public class SubcategoriaDAO {
     public List<Subcategoria> listarTodos() {
        List<Subcategoria> categorias = new ArrayList();
        try {
            java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM categoria");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Subcategoria c = new Subcategoria();
                c.setIdSubcategoria(rs.getInt("idSubcategoria"));
                c.setNome(rs.getString("nome"));
                categorias.add(c);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return categorias;
    }
}
