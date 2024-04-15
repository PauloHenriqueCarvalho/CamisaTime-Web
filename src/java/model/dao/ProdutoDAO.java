/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;


import java.sql.Connection;
import conexao.Conexao;
import java.io.FileInputStream;


import conexao.Conexao;
import java.io.FileInputStream;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Categoria;
import model.bean.Produto;

/**
 *
 * @author Joao Guilherme
 */
public class ProdutoDAO {

    public List<Produto> listarTodosDisponiveis() {
        List<Produto> produtos = new ArrayList();

        try {
            java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "SELECT * FROM produto AS p INNER JOIN estoque AS e ON p.idProduto = e.produto WHERE e.quantidade > 0";

            stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setCategoria(rs.getInt("categoria"));
                p.setValor(rs.getFloat("valor"));
                p.setDesconto(rs.getFloat("desconto"));
                p.setValorFinal(rs.getFloat("valorFinal"));
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return produtos;
    }

    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList();

        try {
            java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM produto");
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setCategoria(rs.getInt("categoria"));
                p.setClube(rs.getInt("clube"));
                p.setValor(rs.getFloat("valor"));
                p.setDesconto(rs.getFloat("desconto"));
                p.setValorFinal(rs.getFloat("valorFinal"));
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return produtos;
    }

    public List<Produto> listarPorCategoria(Categoria c) {
        List<Produto> produtos = new ArrayList();
        try {
            java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "SELECT * FROM produto AS p INNER JOIN categoria AS c ON p.categoria = c.idCategoria WHERE c.nome = ?";

            stmt = conexao.prepareStatement(query);
            stmt.setString(1, c.getNome());

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setCategoria(rs.getInt("categoria"));
                p.setValor(rs.getFloat("valor"));
                p.setDesconto(rs.getFloat("desconto"));
                p.setValorFinal(rs.getFloat("valorFinal"));
                produtos.add(p);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public List<Produto> listarPorPesquisa(String search) {
        List<Produto> produtos = new ArrayList();
        try {
            java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produto WHERE nome LIKE '%?%'");
            stmt.setString(1, search);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setCategoria(rs.getInt("categoria"));
                p.setValor(rs.getFloat("valor"));
                p.setDesconto(rs.getFloat("desconto"));
                p.setValorFinal(rs.getFloat("valorFinal"));
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return produtos;
    }

    public Produto readById(int id) {
        Produto p = new Produto();
        try {
           java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produto WHERE idProduto = ?");

            rs = stmt.executeQuery();

            if (rs.next()) {
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setCategoria(rs.getInt("categoria"));
                p.setValor(rs.getFloat("valor"));
                p.setDesconto(rs.getFloat("desconto"));
                p.setValorFinal(rs.getFloat("valorFinal"));
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void create(Produto p, FileInputStream fis, int tamanho) {
        try {
           java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO produto (nome, categoria, valor, desconto, valorFinal, clube, imagem) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getCategoria());
            stmt.setFloat(3, p.getValor());
            stmt.setFloat(4, p.getDesconto());
            stmt.setFloat(5, p.getValorFinal());
            stmt.setInt(6, p.getClube());
            stmt.setBlob(7, p.getImagem());


            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Produto p, FileInputStream fis, int tamanho) {
        try {
            java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("UPDATE produto SET nome = ?, categoria = ?, valor = ?, desconto = ?, valorFinal = ?, clube = ?, imagem = ? WHERE idProduto = ?");

            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getCategoria());
            stmt.setFloat(3, p.getValor());
            stmt.setFloat(4, p.getDesconto());
            stmt.setFloat(5, p.getValorFinal());
            stmt.setInt(6, p.getClube());
            stmt.setBlob(6, p.getImagem());
            stmt.setInt(7, p.getIdProduto());


            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
           java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
