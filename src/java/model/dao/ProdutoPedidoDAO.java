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
import model.bean.ProdutoPedido;

/**
 *
 * @author Joao Guilherme
 */
public class ProdutoPedidoDAO {

    private void create() {
        try {
            Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "";

            stmt = conexao.prepareStatement(query);

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void adicionarProdutoPedido(int idPedido, String tamanho, int idProduto) {
        String sql = "INSERT INTO produto_pedido (pedido, tamanho, produto) VALUES (?, ?, ?)";

        try {
            Connection conexao = Conexao.getConn();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPedido);
            stmt.setString(2, tamanho);
            stmt.setInt(3, idProduto);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ProdutoPedido> buscarProdutoPedidosPorPedido(int idPedido) throws SQLException {
        List<ProdutoPedido> produtoPedidos = new ArrayList<>();
        String sql = "SELECT * FROM produto_pedido WHERE pedido = ?";
        try {
            Connection conexao = Conexao.getConn();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoPedido produtoPedido = new ProdutoPedido();
                produtoPedido.setIdProdutoPedido(rs.getInt("idProduto_pedido"));
                produtoPedido.setPedido(rs.getInt("pedido"));
                produtoPedido.setTamanho(rs.getString("tamanho"));
                produtoPedido.setProduto(rs.getInt("produto"));
                produtoPedidos.add(produtoPedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtoPedidos;
    }
}
