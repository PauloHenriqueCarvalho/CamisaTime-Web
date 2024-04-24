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
import java.util.ArrayList;
import java.util.List;
import model.bean.Carrinho;
import model.bean.Produto;

/**
 *
 * @author Joao Guilherme
 */
public class CarrinhoProdutoDAO {

    /*try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "";
            
            stmt = conexao.prepareStatement(query);
            
            
            rs.close();
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
                   
        }*/
    private void adicionarProdutoAoCarrinho(Produto p, Carrinho c) {
        try {
           java.sql.Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO produto_pedido (carrinho, produto) VALUES (?, ?)");
            stmt.setInt(1, c.getIdCarrinho());
            stmt.setInt(2, p.getIdProduto());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    
    public List<Produto> listarProdutosDoCarrinho(int idCarrinho) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        Connection con = Conexao.getConn();
        try {
            stmt = con.prepareStatement("SELECT p.* FROM Produto p "
                                        + "INNER JOIN carrinho_produto cp ON p.idProduto = cp.produto "
                                        + "WHERE cp.carrinho = ?");
            stmt.setInt(1, idCarrinho);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getFloat("valor"));
                produto.setDesconto(rs.getFloat("desconto"));
                produto.setValorFinal(rs.getFloat("valorFinal"));
                // Defina outros atributos do produto conforme necessário
                System.out.println("Nome do produto: " + produto.getNome());
                produtos.add(produto);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            
            System.err.println("Erro ao listar produtos do carrinho: " + ex);
        }
        return produtos;
    }

    
}
